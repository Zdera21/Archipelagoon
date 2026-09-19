package archipelagoon.ap.events;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.items.Items;
import archipelagoon.randomizer.AdditionManager;
import archipelagoon.randomizer.MagicManager;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ReceiveItemEvent;
import legend.core.GameEngine;
import legend.game.SItem;
import legend.game.i18n.I18n;
import legend.game.inventory.Equipment;
import legend.game.inventory.Good;
import legend.game.inventory.GoodsSource;
import legend.game.inventory.Item;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.List;
import java.util.Objects;

import static archipelagoon.Archipelagoon.LAST_ITEM_INDEX;
import static archipelagoon.Archipelagoon.MOD_ID;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public class ReceiveItemListener {
  @ArchipelagoEventListener
  public void onReceiveItem(final ReceiveItemEvent event) {
    final APContext ctx = APContext.getContext();

    final long lastItemReceivedIndex = GameEngine.CONFIG.getConfig(LAST_ITEM_INDEX.get());
    if(event.getIndex() <= lastItemReceivedIndex) {
      return;
    }

    final RegistryId registryId = this.getProgressiveRegistryId(event.getItemID());
    if(registryId == null) {
      // no match found, not supported.
      return;
    }

    this.giveItem(registryId);
    GameEngine.CONFIG.setConfig(LAST_ITEM_INDEX.get(), event.getIndex());

    final String message = I18n.translate(MOD_ID + ".ap.event.item_received", event.getItemName(), event.getPlayerName());
    ctx.displayMessage(message);
  }

  private RegistryId getProgressiveRegistryId(final long apItemId) {
    final String itemId = Items.getRegistryIdFromAPItemId(apItemId);

    final APContext ctx = APContext.getContext();
    // This is the list of progressive maps we want to check against
    final List<RegistryId> MATCHERS = List.of(ctx.getProgressiveAdditionMatch(apItemId), ctx.getProgressiveMagicMatch(apItemId), ctx.getProgressiveDartSpiritMatch(apItemId));

    final RegistryId registryId;
    if(itemId != null) {
      registryId = new RegistryId(itemId);
    } else {
      registryId = MATCHERS.stream().filter(Objects::nonNull).findFirst().orElse(null);
    }

    return registryId;
  }

  private void giveItem(final RegistryId registryId) {
    if(GameEngine.REGISTRIES.items.hasEntry(registryId)) {
      final Item item = GameEngine.REGISTRIES.items.getEntry(registryId).get();
      gameState_800babc8.items_2e9.give(item);
    } else if(GameEngine.REGISTRIES.equipment.hasEntry(registryId)) {
      final Equipment equipment = GameEngine.REGISTRIES.equipment.getEntry(registryId).get();
      SItem.giveEquipment(equipment);
    } else if(GameEngine.REGISTRIES.goods.hasEntry(registryId)) {
      final Good good = GameEngine.REGISTRIES.goods.getEntry(registryId).get();
      gameState_800babc8.goods_19c.give(good, GoodsSource.EXTERNAL);
    } else if(GameEngine.REGISTRIES.additions.hasEntry(registryId)) {
      AdditionManager.getInstance().unlockAddition(registryId, null);
    } else if(GameEngine.REGISTRIES.spells.hasEntry(registryId)) {
      MagicManager.getInstance().setSpell(registryId, null);
    }
  }
}
