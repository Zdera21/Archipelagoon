package archipelagoon;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.LocationState;
import archipelagoon.ap.mapping.items.Goods;
import archipelagoon.ap.mapping.locations.Additions;
import archipelagoon.ap.mapping.locations.GoodsLocations;
import archipelagoon.config.ArchipelagoConfigEntry;
import archipelagoon.config.GoldMultiplierConfigEntry;
import archipelagoon.config.ItemIndexConfigEntry;
import archipelagoon.config.LocationStateRegistry;
import archipelagoon.config.XpMultiplierConfigEntry;
import archipelagoon.data.APInventoryEntry;
import archipelagoon.data.APShopExtension;
import archipelagoon.data.SlotData;
import archipelagoon.data.enums.AdditionRandomizerType;
import archipelagoon.icons.APIconUiType;
import archipelagoon.randomizer.AdditionManager;
import archipelagoon.randomizer.MagicManager;
import archipelagoon.randomizer.ShopManager;
import legend.core.GameEngine;
import legend.core.lang.I18nText;
import legend.game.combat.BattleTransitionMode;
import legend.game.combat.deff.RegisterDeffsEvent;
import legend.game.combat.effects.TransformationMode;
import legend.game.inventory.Good;
import legend.game.inventory.GoodsRegistryEvent;
import legend.game.inventory.GoodsSource;
import legend.game.inventory.Item;
import legend.game.inventory.ItemRegistryEvent;
import legend.game.inventory.screens.GatherShopExtensionsEvent;
import legend.game.inventory.screens.ShopScreen;
import legend.game.modding.coremod.config.QuickTextMode;
import legend.game.modding.events.RenderEvent;
import legend.game.modding.events.battle.BattleEndedEvent;
import legend.game.modding.events.battle.EnemyRewardsEvent;
import legend.game.modding.events.characters.AdditionUnlockEvent;
import legend.game.modding.events.characters.PostCharacterDragoonLevelUpEvent;
import legend.game.modding.events.characters.PostCharacterLevelUpEvent;
import legend.game.modding.events.gamestate.GameLoadedEvent;
import legend.game.modding.events.gamestate.NewGameEvent;
import legend.game.modding.events.inventory.GiveGoodsEvent;
import legend.game.modding.events.inventory.ShopBuyEvent;
import legend.game.modding.events.inventory.ShopContentsEvent;
import legend.game.modding.events.inventory.TakeGoodsEvent;
import legend.game.modding.events.scripting.ReadGlobalFlagsEvent;
import legend.game.saves.ConfigCategory;
import legend.game.saves.ConfigCollection;
import legend.game.saves.ConfigDefaultPresetsEvent;
import legend.game.saves.ConfigEntry;
import legend.game.saves.ConfigPreset;
import legend.game.saves.ConfigPresetEntry;
import legend.game.saves.ConfigRegistryEvent;
import legend.game.saves.ConfigStorageLocation;
import legend.game.saves.StringConfigEntry;
import legend.game.scripting.ScriptFlagArrayEnum;
import legend.lodmod.LodGoods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.legendofdragoon.modloader.Mod;
import org.legendofdragoon.modloader.events.EventListener;
import org.legendofdragoon.modloader.registries.Registrar;
import org.legendofdragoon.modloader.registries.RegistryDelegate;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static legend.core.GameEngine.EVENTS;
import static legend.game.SItem.buildUiRenderable;
import static legend.game.Scus94491BpeSegment_8005.submapCut_80052c30;
import static legend.game.Scus94491BpeSegment_8006.battleState_8006e398;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;
import static legend.game.modding.coremod.CoreMod.AUTO_TEXT_CONFIG;
import static legend.game.modding.coremod.CoreMod.AUTO_TEXT_DELAY_CONFIG;
import static legend.game.modding.coremod.CoreMod.BATTLE_TRANSITION_MODE_CONFIG;
import static legend.game.modding.coremod.CoreMod.INVENTORY_SIZE_CONFIG;
import static legend.game.modding.coremod.CoreMod.QUICK_TEXT_CONFIG;
import static legend.game.modding.coremod.CoreMod.SAVE_ANYWHERE_CONFIG;
import static legend.game.modding.coremod.CoreMod.SECONDARY_CHARACTER_XP_MULTIPLIER_CONFIG;
import static legend.game.modding.coremod.CoreMod.TRANSFORMATION_MODE_CONFIG;
import static legend.game.modding.coremod.CoreMod.UNLOCK_PARTY_CONFIG;
import static legend.lodmod.LodConfig.EXTENDED_DRAGOON_ACTIONS;
import static legend.lodmod.LodConfig.ITEM_STACK_SIZE;

@Mod(id = Archipelagoon.MOD_ID, version = "^3.0.0")
public class Archipelagoon {
  public static final String MOD_ID = "archipelagoon";
  private static final Registrar<ConfigEntry<?>, ConfigRegistryEvent> CONFIG_REGISTRAR = new Registrar<>(GameEngine.REGISTRIES.config, MOD_ID);
  public static final RegistryDelegate<ArchipelagoConfigEntry> ARCHIPELAGO_CONFIG = CONFIG_REGISTRAR.register("archipelago_config", ArchipelagoConfigEntry::new);
  public static final RegistryDelegate<StringConfigEntry> ADDRESS_CONFIG = CONFIG_REGISTRAR.register("address", () -> new StringConfigEntry("archipelago.gg:12345", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<StringConfigEntry> SLOT_NAME_CONFIG = CONFIG_REGISTRAR.register("slot_name", () -> new StringConfigEntry("", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<StringConfigEntry> PASSWORD_CONFIG = CONFIG_REGISTRAR.register("password", () -> new StringConfigEntry("", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<XpMultiplierConfigEntry> XP_MULTIPLIER_CONFIG = CONFIG_REGISTRAR.register("xp_multiplier", XpMultiplierConfigEntry::new);
  public static final RegistryDelegate<GoldMultiplierConfigEntry> GOLD_MULTIPLIER_CONFIG = CONFIG_REGISTRAR.register("gold_multiplier", GoldMultiplierConfigEntry::new);
  public static final RegistryDelegate<ItemIndexConfigEntry> LAST_ITEM_INDEX = CONFIG_REGISTRAR.register("last_item_index", () -> new ItemIndexConfigEntry(0));
  public static final RegistryDelegate<LocationStateRegistry> LOCATION_STATE_REGISTRY = CONFIG_REGISTRAR.register("location_states", LocationStateRegistry::new);
  private static final Registrar<Item, ItemRegistryEvent> ITEM_REGISTRAR = new Registrar<>(GameEngine.REGISTRIES.items, MOD_ID);
  private static final Logger LOGGER = LogManager.getFormatterLogger(Archipelagoon.class);

  public Archipelagoon() {
    EVENTS.register(this);
  }

  private static ConfigPreset getArchipelagoonDefaultPreset() {
    final ConfigCollection config = new ConfigCollection();
    config.setConfig(BATTLE_TRANSITION_MODE_CONFIG.get(), BattleTransitionMode.INSTANT);
    config.setConfig(TRANSFORMATION_MODE_CONFIG.get(), TransformationMode.SHORT);
    config.setConfig(AUTO_TEXT_CONFIG.get(), true);
    config.setConfig(AUTO_TEXT_DELAY_CONFIG.get(), 0.0f);
    config.setConfig(QUICK_TEXT_CONFIG.get(), QuickTextMode.INSTANT);
    config.setConfig(UNLOCK_PARTY_CONFIG.get(), true);
    config.setConfig(SAVE_ANYWHERE_CONFIG.get(), true);
    config.setConfig(SECONDARY_CHARACTER_XP_MULTIPLIER_CONFIG.get(), 1.0f);
    config.setConfig(INVENTORY_SIZE_CONFIG.get(), 108);
    config.setConfig(ITEM_STACK_SIZE.get(), 32);
    config.setConfig(EXTENDED_DRAGOON_ACTIONS.get(), true);

    return new ConfigPreset(new I18nText(MOD_ID + ".config_presets.default"), config);
  }

  @EventListener
  public void presetEvent(final ConfigDefaultPresetsEvent event) {
    final ConfigPreset defaultPreset = getArchipelagoonDefaultPreset();

    event.presetEntries.add(new ConfigPresetEntry(null, defaultPreset.name, CompletableFuture.completedFuture(defaultPreset), false));
  }

  @EventListener
  public void registerItems(final ItemRegistryEvent event) {
    APItems.register(event);
  }

  @EventListener
  public void registerGoods(final GoodsRegistryEvent event) {
    APGoods.register(event);
  }

  @EventListener
  public void registerDeffs(final RegisterDeffsEvent event) {
    APDeffs.register(event);
  }

  @EventListener
  public void gameConfig(final ConfigRegistryEvent event) {
    CONFIG_REGISTRAR.registryEvent(event);
  }

  @EventListener
  public void newGame(final NewGameEvent event) {
    final APContext ctx = APContext.getContext();
    ctx.initGame(event.gameState);
    // causes error on new game, still works though?
    submapCut_80052c30 = 10; // warp to seles
  }

  @EventListener
  public void gatherShopExtensions(final GatherShopExtensionsEvent event) {
    event.addExtension(new APShopExtension(), 999);
  }

  @EventListener
  public void gameLoaded(final GameLoadedEvent game) {
    final APContext ctx = APContext.getContext();

    if(ctx.isConnected()) {
      ctx.initAdditions(game.gameState);
      ctx.initMagic(game.gameState);
    }

    try {
      ctx.reconnect();
    } catch(final URISyntaxException e) {
      // Will only happen if the player submits a malformed URL
      LOGGER.error("User error - malformed URL", e);
      //TODO should probably display a message or something
    }
  }

  @EventListener
  public void additionUnlock(final AdditionUnlockEvent event) {
    final APContext ctx = APContext.getContext();
    if(AdditionRandomizerType.values()[ctx.getSlotData().additionRandomizer] == AdditionRandomizerType.OFF) {
      return;
    }

    if(!Additions.getStaticMap().containsValue(event.addition.getRegistryId().toString())) {
      return;
    }

    final long apId = Additions.getAPLocationIdFromRegistryId(event.addition.getRegistryId());

    final List<LocationState> locationStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final LocationState locationState = locationStates.stream().filter(ls -> ls.getLocationID() == apId).findFirst().orElse(null);

    event.cancel();

    if(locationState == null) {
      return;
    }

    if(locationState.isApplied()) {
      return;
    }

    ctx.applyLocationState(locationState.getLocationID());
    ctx.checkLocation(locationState.getLocationID());
  }

  @EventListener
  public void shopContents(final ShopContentsEvent event) {
    final APContext ctx = APContext.getContext();
    final SlotData slotData = ctx.getSlotData();
    if(slotData.enableShopsanity == 0) {
      return;
    }

    final List<ShopScreen.ShopEntry<?>> adjustedContents = new ArrayList<>();

    adjustedContents.addAll(ShopManager.getInstance().getRepeatConsumables());
    adjustedContents.addAll(ShopManager.getInstance().getShopItems(event.shop));

    event.contents.clear();
    event.contents.addAll((Collection)adjustedContents);
  }

  @EventListener
  public void shopBuy(final ShopBuyEvent event) {
    if(!(event.item instanceof final APInventoryEntry entry)) {
      return;
    }

    final APContext ctx = APContext.getContext();
    final List<LocationState> locationStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final LocationState locationState = locationStates.stream().filter(ls -> ls.getLocationID() == entry.locationId).findFirst().orElse(null);
    if(locationState == null) {
      return;
    }

    ctx.applyLocationState(locationState.getLocationID());
    ctx.checkLocation(entry.locationId);
  }

  @EventListener
  public void giveGood(final GiveGoodsEvent event) {
    final APContext ctx = APContext.getContext();
    if(!ctx.isConnected()) {
      return;
    }

    final Set<Long> receivedIds = Set.copyOf(ctx.getReceivedItemIDs());
    final List<Good> allowedGoods = new ArrayList<>();

    switch(event.source) {
      case GoodsSource.INITIALIZATION:
        // probably can ignore?
        break;
      case GoodsSource.DEBUGGER:
      case GoodsSource.EXTERNAL:
        allowedGoods.addAll(this.handleExternalGoods(event.givenGoods, receivedIds));
        // handle AP? good
        break;
      case GoodsSource.GAMEPLAY:
        // given from story
        allowedGoods.addAll(this.handleGameplayGoods(event.givenGoods, receivedIds));
        break;
      default:
        break;
    }

    if(allowedGoods.isEmpty()) {
      event.cancel();
    } else {
      event.givenGoods.clear();
      event.givenGoods.addAll(allowedGoods);
    }
  }

  private Collection<? extends Good> handleGameplayGoods(final List<Good> givenGoods, final Set<Long> receivedIds) {
    final List<Good> allowedGoods = new ArrayList<>();

    for(final Good good : givenGoods) {
      final RegistryId id = good.getRegistryId();
      final Long apId;
      if(Objects.equals(id, LodGoods.LAW_MAKER.getId())) {
        apId = Goods.getAPItemIdFromRegistryId(APGoods.LAW_MAKING_LICENSE.getId());
      } else if(Objects.equals(id, LodGoods.LAW_OUTPUT.getId())) {
        apId = Goods.getAPItemIdFromRegistryId(APGoods.LAW_LAUNCHING_LICENSE.getId());
      } else {
        // if not law maker or law output, we check a location
        //        apId = Goods.getAPItemIdFromRegistryId(id);
        final APContext ctx = APContext.getContext();
        ctx.checkLocation(GoodsLocations.getAPLocationId(id));
        // no good to add here
        apId = null;
      }

      if(apId == null) {
        continue;
      }

      if(receivedIds.contains(apId)) {
        allowedGoods.add(good);
      }
    }

    return allowedGoods;
  }

  private Collection<? extends Good> handleExternalGoods(final List<Good> givenGoods, final Set<Long> receivedIds) {
    final List<Good> allowedGoods = new ArrayList<>();

    for(final Good good : givenGoods) {
      final Long apId = Goods.getAPItemIdFromRegistryId(good.getRegistryId());
      if(apId == null) {
        continue;
      }

      if(receivedIds.contains(apId)) {
        allowedGoods.add(good);
      }
    }

    return allowedGoods;
  }

  @EventListener
  public void takeGood(final TakeGoodsEvent event) {
    final List<Good> allowedGoods = new ArrayList<>();

    for(final Good good : event.takenGoods) {
      if(Objects.equals(good.getRegistryId(), LodGoods.LAW_MAKER.getId())) {
        allowedGoods.add(good);
      }

      if(Objects.equals(good.getRegistryId(), LodGoods.LAW_OUTPUT.getId())) {
        allowedGoods.add(good);
      }
    }

    if(allowedGoods.isEmpty()) {
      event.cancel();
    } else {
      event.takenGoods.clear();
      event.takenGoods.addAll(allowedGoods);
    }
  }

  @EventListener
  public void characterLevelUp(final PostCharacterLevelUpEvent event) {
    AdditionManager.getInstance().checkUnlock(event.character);
  }

  @EventListener
  public void dragoonLevelUp(final PostCharacterDragoonLevelUpEvent event) {
    MagicManager.getInstance().checkUnlock(event.character);
  }

  @EventListener
  public void battleEnded(final BattleEndedEvent event) {
    final APContext ctx = APContext.getContext();
    if(battleState_8006e398.hasAlivePlayers()) {
      ctx.handleEncounter(event.encounter.getRegistryId());
      return;
    }

    if(ctx.getSlotData().deathLink == 1) {
      ctx.sendDeathlink();
    }
  }

  @EventListener
  public void enemyRewards(final EnemyRewardsEvent event) {
    event.xp *= GameEngine.CONFIG.getConfig(XP_MULTIPLIER_CONFIG.get());
    event.gold *= GameEngine.CONFIG.getConfig(GOLD_MULTIPLIER_CONFIG.get());
  }

  @EventListener
  public void onRender(final RenderEvent event) {

    if(APIconUiType._ICONS.obj == null) {
      APIconUiType._ICONS.obj = buildUiRenderable(APIconUiType._ICONS, "AP icons");
      APIconUiType._ICONS.obj.persistent = true;
    }

    final APContext ctx = APContext.getContext();
    ctx.renderMessage();
  }

  @EventListener
  public void readScriptFlags(final ReadGlobalFlagsEvent event) {
    if(event.flagArray == ScriptFlagArrayEnum.FLAGS2) {
      switch(event.getFlagIndex()) {
        case 59:
          event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.LIFE_WATER.getId()));
        case 58:
          event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.WATER_BOTTLE.getId()));
        case 9:
          event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.PRISON_KEY.getId()));
        case 203:
          event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.BOAT_LICENSE.getId()));
      }
    } else if(event.flagArray == ScriptFlagArrayEnum.FLAGS1) {
      switch(event.getFlagIndex()) {
        case 1:
          event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.AXE_FROM_THE_SHACK.getId()));
      }
    }
  }

/* Example of giving the player an ice trap item impersonating healing breeze
  @EventListener
  public void onLoad(final GameLoadedEvent event) {
    event.gameState.items_2e9.give(APItems.ICE_TRAP.get().impersonate(LodItems.HEALING_BREEZE.get()));
  }
*/
}
