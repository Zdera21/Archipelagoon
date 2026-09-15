package archipelagoon.randomizer;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.items.Magic;
import archipelagoon.ap.mapping.locations.DragoonLevels;
import archipelagoon.data.enums.MagicRandomizerType;
import archipelagoon.data.tables.ProgressiveSpells;
import legend.core.GameEngine;
import legend.game.additions.UnlockState;
import legend.game.characters.CharacterData2c;
import legend.game.characters.CharacterSpellInfo;
import legend.game.types.GameState52c;
import legend.lodmod.LodSpells;
import legend.lodmod.characters.DartCharacterData;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public class MagicManager {
  private static final MagicManager INSTANCE = new MagicManager();

  private MagicManager() {
  }

  public static MagicManager getInstance() {
    return INSTANCE;
  }

  public void lockSpells(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c.get(charIndex);
      final Collection<RegistryId> spellIds = new ArrayList<>();
      if(charIndex == 0) {
        final DartCharacterData dartData = (DartCharacterData)charData;
        spellIds.addAll(dartData.getDivineSpells());
        spellIds.addAll(dartData.getRedEyeSpells());
      } else {
        spellIds.addAll(charData.getAllSpells());
      }

      final int finalCharIndex = charIndex;
      spellIds.forEach(spell -> {
        final int timestamp = 0;
        if(finalCharIndex == 0) {
          this.getDartMagic(state, spell).setUnlockState(UnlockState.LOCKED, timestamp);
        } else {
          charData.getSpellInfo(spell).setUnlockState(UnlockState.LOCKED, timestamp);
        }
      });
    }
  }

  public void setMagic(final GameState52c gameState) {
    final APContext ctx = APContext.getContext();
    final MagicRandomizerType type = MagicRandomizerType.values()[ctx.getSlotData().magicRandomizer];
    switch(type) {
      case MagicRandomizerType.PROGRESSIVE:
        this.setProgressive(gameState);
        break;
      case MagicRandomizerType.SHUFFLED:
        this.setShuffled(gameState);
        break;
    }
  }

  private void setShuffled(final GameState52c gameState) {
    final Map<Long, RegistryId> spellList = Magic.getStaticMap();
    final GameState52c state = this.resolveState(gameState);
    final APContext ctx = APContext.getContext();

    for(final Long id : ctx.getReceivedItemIDs()) {
      if(!spellList.containsKey(id)) {
        continue;
      }

      final RegistryId registryId = Magic.getRegistryIdFromAPItemId(id);
      this.setSpell(registryId, state);
    }
  }

  private void setProgressive(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    final APContext ctx = APContext.getContext();
    final List<Long> receivedItems = ctx.getReceivedItemIDs();

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c.get(charIndex);
      final Long progressiveId = Magic.getAPItemIdFromCharacterIndex(charIndex);
      final int totalReceived = Collections.frequency(receivedItems, progressiveId);
      final Map<Integer, RegistryId> spells = ProgressiveSpells.getSpellsForChar(charIndex);
      for(int i = 1; i <= totalReceived; i++) {
        if(!spells.containsKey(i)) {
          break;
        }

        final RegistryId registryId = spells.get(i);
        final CharacterSpellInfo info;
        if(charIndex == 0) {
          info = this.getDartMagic(state, registryId);
        } else {
          info = charData.getSpellInfo(registryId);
        }

        info.setUnlockState(UnlockState.UNLOCKED, state.timestamp_a0);
      }
    }
  }

  public void setSpell(final RegistryId spellId, final GameState52c gameState) {
    if(!GameEngine.REGISTRIES.spells.hasEntry(spellId)) {
      return;
    }

    final GameState52c state = this.resolveState(gameState);

    for(int charIndex = 0; charIndex < 9; charIndex++) {
      final CharacterData2c charData = state.charData_32c.get(charIndex);
      final CharacterSpellInfo info;
      if(charIndex == 0) {
        info = this.getDartMagic(state, spellId);
      } else {
        info = charData.getSpellInfo(spellId);
      }

      if(info == null) {
        continue;
      }

      info.setUnlockState(UnlockState.UNLOCKED, state.timestamp_a0);
    }
  }

  public void checkUnlock(final CharacterData2c charData) {
    final APContext ctx = APContext.getContext();
    for(int i = 1; i <= charData.dlevel_13; i++) {
      final Long apId = DragoonLevels.getLocationId(charData.template.getRegistryId(), i);
      if(apId == null || apId == -1L) {
        continue;
      }

      ctx.checkLocation(apId);
    }
  }

  public RegistryId getProgressiveMagicRegistryId(final long itemId) {
    final APContext ctx = APContext.getContext();
    final List<Long> receivedItems = ctx.getReceivedItemIDs();

    final int charIndex = Magic.getCharacterIndexFromAPItemId(itemId);
    if(charIndex == -1) {
      return null;
    }

    final int totalReceived = Collections.frequency(receivedItems, itemId);
    final Map<Integer, RegistryId> spells = ProgressiveSpells.getSpellsForChar(charIndex);

    if(!spells.containsKey(totalReceived)) {
      return null;
    }

    return spells.get(totalReceived);
  }

  private CharacterSpellInfo getDartMagic(final GameState52c state, final RegistryId spellRegistryId) {
    final DartCharacterData dartData = (DartCharacterData)state.charData_32c.getFirst();
    final boolean isDivineSpell = spellRegistryId == LodSpells.DIVINE_DG_BALL.getId() || spellRegistryId == LodSpells.DIVINE_DG_CANNON.getId();
    if(isDivineSpell) {
      return dartData.getDivineSpellInfo(spellRegistryId);
    } else {
      return dartData.getRedEyeSpellInfo(spellRegistryId);
    }
  }

  private GameState52c resolveState(final GameState52c state) {
    return state != null ? state : gameState_800babc8;
  }
}
