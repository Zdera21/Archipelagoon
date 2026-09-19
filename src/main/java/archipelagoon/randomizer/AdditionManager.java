package archipelagoon.randomizer;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.items.Additions;
import archipelagoon.data.enums.AdditionRandomizerType;
import archipelagoon.data.tables.ProgressiveAdditions;
import legend.core.GameEngine;
import legend.game.additions.UnlockState;
import legend.game.characters.CharacterAdditionInfo;
import legend.game.characters.CharacterData2c;
import legend.game.types.GameState52c;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public final class AdditionManager {
  private static final AdditionManager INSTANCE = new AdditionManager();

  private AdditionManager() {
  }

  public static AdditionManager getInstance() {
    return INSTANCE;
  }

  public void lockAdditions(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c.get(charIndex);
      charData.getAllAdditions().forEach(addition -> {
        final int timestamp = 0;
        charData.getAdditionInfo(addition).setUnlockState(UnlockState.LOCKED, timestamp);
      });
    }
  }

  public void setAdditions(final GameState52c gameState) {
    final APContext ctx = APContext.getContext();

    switch(AdditionRandomizerType.values()[ctx.getSlotData().additionRandomizer]) {
      case AdditionRandomizerType.SHUFFLED:
        this.setShuffled(gameState);
        break;
      case AdditionRandomizerType.PROGRESSIVE:
        this.setProgressive(gameState);
        break;
    }
  }

  private void setShuffled(final GameState52c gameState) {
    final Map<Long, String> additionList = Additions.getStaticMap();
    final GameState52c state = this.resolveState(gameState);
    final APContext ctx = APContext.getContext();

    for(final Long id : ctx.getReceivedItemIDs()) {
      if(!additionList.containsKey(id)) {
        continue;
      }

      final RegistryId registryId = new RegistryId(Additions.getRegistryIdFromAPItemId(id));
      this.unlockAddition(registryId, state);
    }
  }

  private void setProgressive(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    final APContext ctx = APContext.getContext();
    final List<Long> receivedItems = ctx.getReceivedItemIDs();

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c.get(charIndex);
      final Long progressiveId = Additions.getAPItemIdFromCharacterIndex(charIndex);
      final int totalReceived = Collections.frequency(receivedItems, progressiveId);
      final Map<Integer, RegistryId> additions = ProgressiveAdditions.getAdditionsForChar(charIndex);

      for(int i = 1; i <= totalReceived; i++) {
        if(!additions.containsKey(i)) {
          break;
        }

        final RegistryId registryId = additions.get(i);

        final CharacterAdditionInfo additionInfo = charData.getAdditionInfo(registryId);
        if(additionInfo.getUnlockState() != UnlockState.UNLOCKED) {
          additionInfo.setUnlockState(UnlockState.UNLOCKED, state.timestamp_a0);
        }
      }
    }
  }

  public void unlockAddition(final RegistryId registryId, final GameState52c gameState) {
    if(!GameEngine.REGISTRIES.additions.hasEntry(registryId)) {
      return;
    }

    final GameState52c state = this.resolveState(gameState);

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c.get(charIndex);
      final CharacterAdditionInfo info = charData.getAdditionInfo(registryId);
      if(info == null) {
        continue;
      }

      final CharacterAdditionInfo additionInfo = charData.getAdditionInfo(registryId);
      if(additionInfo.getUnlockState() != UnlockState.UNLOCKED) {
        additionInfo.setUnlockState(UnlockState.UNLOCKED, state.timestamp_a0);
      }
    }
  }

  public void selectAddition(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);
    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c.get(charIndex);
      final CharacterAdditionInfo addition = charData.getAdditionInfo(charData.selectedAddition_19);
      if(addition == null) {
        continue;
      }

      if(addition.getUnlockState() == UnlockState.UNLOCKED) {
        break;
      }

      for(final RegistryId entry : charData.getAllAdditions()) {
        if(charData.getAdditionInfo(entry).getUnlockState() == UnlockState.UNLOCKED) {
          charData.selectedAddition_19 = entry;
          break;
        }
      }
    }
  }

  public void checkUnlock(final CharacterData2c charData) {
    final APContext apContext = APContext.getContext();

    for(final RegistryId id : charData.getAllAdditions()) {

      final CharacterAdditionInfo info = charData.getAdditionInfo(id);

      final var addition = GameEngine.REGISTRIES.additions.getEntry(id).get();
      if(addition == null) {
        continue;
      }

      if(info.checkUnlockCriteria(charData)) {
        final Long apId = archipelagoon.ap.mapping.locations.Additions.getAPLocationIdFromRegistryId(id);
        if(apId != null) {
          apContext.checkLocation(apId);
        }
      }
    }
  }

  private GameState52c resolveState(final GameState52c state) {
    return state != null ? state : gameState_800babc8;
  }

  public RegistryId getProgressiveAdditionRegistryId(final long itemId) {
    final APContext ctx = APContext.getContext();
    final List<Long> receivedItems = ctx.getReceivedItemIDs();

    final int charIndex = Additions.getCharacterIndexFromAPItemId(itemId);
    if(charIndex == -1) {
      return null;
    }

    final int totalReceived = Collections.frequency(receivedItems, itemId);
    final Map<Integer, RegistryId> additions = ProgressiveAdditions.getAdditionsForChar(charIndex);

    if(!additions.containsKey(totalReceived)) {
      return null;
    }

    return additions.get(totalReceived);
  }
}