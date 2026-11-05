package archipelagoon.ap;

import archipelagoon.Archipelagoon;
import archipelagoon.ap.mapping.LocationState;
import archipelagoon.ap.mapping.goals.Goals;
import archipelagoon.ap.mapping.locations.DragoonLevels;
import archipelagoon.ap.mapping.locations.Enemies;
import archipelagoon.ap.mapping.locations.Locations;
import archipelagoon.data.SlotData;
import archipelagoon.data.enums.ChestType;
import archipelagoon.data.tables.ProgressiveDartSpirit;
import archipelagoon.randomizer.AdditionManager;
import archipelagoon.randomizer.CharacterManager;
import archipelagoon.randomizer.ChestManager;
import archipelagoon.randomizer.DeathlinkManager;
import archipelagoon.randomizer.MagicManager;
import archipelagoon.randomizer.MessageManager;
import io.github.archipelagomw.APResult;
import io.github.archipelagomw.ClientStatus;
import io.github.archipelagomw.flags.ItemsHandling;
import io.github.archipelagomw.network.client.CreateAsHint;
import legend.core.GameEngine;
import legend.game.i18n.I18n;
import legend.game.types.GameState52c;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static archipelagoon.Archipelagoon.ADDRESS_CONFIG;
import static archipelagoon.Archipelagoon.LOCATION_STATE_REGISTRY;
import static archipelagoon.Archipelagoon.PASSWORD_CONFIG;
import static archipelagoon.Archipelagoon.SLOT_NAME_CONFIG;
import static archipelagoon.data.tables.ProgressiveDartSpirit.DART_PROGRESSIVE_SPIRIT_ITEM_ID;

public class APContext {
  private static final APContext INSTANCE = new APContext();
  private final APClient client;
  private final AdditionManager additionManager = AdditionManager.getInstance();
  private final MagicManager magicManager = MagicManager.getInstance();
  private final MessageManager messageManager = MessageManager.getInstance();
  private final DeathlinkManager deathlinkManager = DeathlinkManager.getInstance();
  private final CharacterManager characterManager = CharacterManager.getInstance();
  private final ChestManager chestManager = ChestManager.getInstance();
  private SlotData slotData;

  public APContext() {
    this.client = new APClient();
  }

  public static APContext getContext() {
    return INSTANCE;
  }

  public void displayMessage(final String message) {
    this.messageManager.displayMessage(message);
  }

  public void reconnect() throws URISyntaxException {
    if(this.isConnected()) {
      this.disconnect();
    }

    final String address = GameEngine.CONFIG.getConfig(ADDRESS_CONFIG.get());
    final String slotName = GameEngine.CONFIG.getConfig(SLOT_NAME_CONFIG.get());
    final String password = GameEngine.CONFIG.getConfig(PASSWORD_CONFIG.get());
    if(address.isEmpty() || slotName.isEmpty()) {
      return;
    }

    this.connect(address, slotName, password);
  }

  public void connect(final String address, final String slotName, final String password) throws URISyntaxException {
    if(this.isConnected() || address.isEmpty() || slotName.isEmpty()) {
      return;
    }

    this.client.connectToServer(address, slotName, password);
    this.client.setItemsHandlingFlags(ItemsHandling.SEND_ITEMS + ItemsHandling.SEND_OWN_ITEMS + ItemsHandling.SEND_STARTING_INVENTORY);
  }

  public boolean isConnected() {
    return this.client.isConnected();
  }

  public void triggerDeathFromAP(final String source, final String cause) {
    final String deathMessage = I18n.translate(Archipelagoon.MOD_ID + ".ap.event.deathlink", source, cause);
    this.messageManager.displayMessage(deathMessage);
    this.deathlinkManager.receiveDeathlink();
  }

  public void sendDeathlink() {
    this.deathlinkManager.sendDeathlink(this.client);
  }

  public void checkLocation(final Long locationId) {
    if(this.client.isAlreadyChecked(locationId)) {
      return;
    }

    if(this.client.checkLocation(locationId).getCode() != APResult.ResultCode.SUCCESS) {
      return;
    }

    final LocationState item = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get()).stream()
      .filter(ls -> locationId.equals(ls.getLocationID())).findFirst().orElse(null);

    if(item != null) {
      final String sendMessage = I18n.translate(Archipelagoon.MOD_ID + ".ap.event.checkLocation", item.getItemName(), item.getPlayerName());
      this.messageManager.displayMessage(sendMessage);
    }
  }

  public void checkLocations(final ArrayList<Long> ids) {
    if(this.client.checkLocations(ids).getCode() != APResult.ResultCode.SUCCESS) {
      return;
    }

    ids.forEach(id -> {
      final LocationState item = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get()).stream()
        .filter(ls -> id.equals(ls.getLocationID())).findFirst().orElse(null);

      if(item != null) {
        final String sendMessage = I18n.translate(Archipelagoon.MOD_ID + ".ap.event.checkLocation", item.getItemName(), item.getPlayerName());
        this.messageManager.displayMessage(sendMessage);
      }
    });
  }

  public void retrieveLocations() {
    final ArrayList<Long> locationIDs = new ArrayList<>(Locations.getStaticMap().keySet());
    locationIDs.addAll(DragoonLevels.getAllLocationIds());
    final var result = this.client.scoutLocations(locationIDs, CreateAsHint.NO);
  }

  public SlotData getSlotData() {
    return this.slotData;
  }

  public void setSlotData(final SlotData slotData) {
    this.slotData = slotData;
  }

  public void handleEncounter(final RegistryId encounterRegistryId) {
    if(encounterRegistryId == null) {
      return;
    }

    final Map<String, Long> reverseMap = Enemies.getStaticReverseMap();

    if(!reverseMap.containsKey(encounterRegistryId.toString())) {
      return;
    }

    this.checkEncounter(encounterRegistryId);
    this.tryGoal(encounterRegistryId);
  }

  public void checkEncounter(final RegistryId encounterRegistryId) {
    final long apId = Enemies.getAPLocationIdFromRegistryId(encounterRegistryId);
    final List<LocationState> locationStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final LocationState locationState = locationStates.stream()
      .filter(ls -> ls.getLocationID() == apId)
      .findFirst()
      .orElse(null);

    if(locationState == null) {
      return;
    }

    if(locationState.isApplied()) {
      return;
    }

    final Long location = Enemies.getAPLocationIdFromRegistryId(encounterRegistryId);
    if(location != null) {
      this.checkLocation(locationState.getLocationID());
    }
  }

  public void tryGoal(final RegistryId encounter) {
    final Map<Integer, String> goals = Goals.getStaticMap();
    final int goalId = APContext.getContext().getSlotData().completionCondition;

    if(Objects.equals(goals.get(goalId), encounter.toString())) {
      this.client.setGameState(ClientStatus.CLIENT_GOAL);
    }
  }

  public List<Long> getReceivedItemIDs() {
    return this.client.getItemManager().getReceivedItemIDs();
  }

  public void applyLocationState(final Long locationId) {
    final List<LocationState> locationStates = new ArrayList<>(GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get()));

    for(final LocationState ls : locationStates) {
      if(ls.getLocationID() == locationId) {
        ls.setApplied(true);
        break;
      }
    }

    GameEngine.CONFIG.setConfig(LOCATION_STATE_REGISTRY.get(), locationStates);
  }

  public void initAdditions(final GameState52c gameState) {
    this.additionManager.setAdditions(gameState);
  }

  public void initMagic(final GameState52c gameState) {
    this.magicManager.setMagic(gameState);
  }

  public void initGame(final GameState52c state) {
    this.additionManager.lockAdditions(state);
    this.magicManager.lockSpells(state);
    this.characterManager.lockCharacters(state);
    this.characterManager.setStartingEquipment(state);
  }

  public void retrieveItems() {
    this.client.getItemManager().getReceivedItems();
  }

  public void disconnect() {
    if(this.isConnected()) {
      this.client.disconnect();
    }
  }

  public void renderMessage() {
    this.messageManager.render();
  }

  public RegistryId getProgressiveAdditionMatch(final long itemId) {
    return this.additionManager.getProgressiveAdditionRegistryId(itemId);
  }

  public RegistryId getProgressiveMagicMatch(final long itemId) {
    return this.magicManager.getProgressiveMagicRegistryId(itemId);
  }

  public RegistryId getProgressiveDartSpiritMatch(final long itemId) {
    final APContext ctx = APContext.getContext();
    final List<Long> receivedItems = ctx.getReceivedItemIDs();

    if(itemId != DART_PROGRESSIVE_SPIRIT_ITEM_ID) {
      return null;
    }

    final int totalReceived = Collections.frequency(receivedItems, itemId);
    final Map<Integer, RegistryId> spiritMap = ProgressiveDartSpirit.getStaticMap();

    if(!spiritMap.containsKey(totalReceived)) {
      return null;
    }

    return spiritMap.get(totalReceived);
  }

  public void enableDeathlink() {
    this.client.setDeathLinkEnabled(true);
  }

  public void handleChest(final ChestType _chestType) {
    final boolean isFromChest = StackWalker
      .getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
      .walk(frames -> frames
        .filter(frame ->
          "scriptGiveChestContents".equals(frame.getMethodName())
        )
        .findFirst()
      ).isPresent();

    if(!isFromChest) {
      return;
    }

    final Long locationId = this.chestManager.getChestId();

    if(locationId == -1) {
      return;
    }

    this.checkLocation(locationId);
  }

  public void storeObjectIndex(int scriptIndex) {
    this.chestManager.updateObjectIndex(scriptIndex);
  }
}
