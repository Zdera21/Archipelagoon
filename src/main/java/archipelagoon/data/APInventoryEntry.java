package archipelagoon.data;

import archipelagoon.ap.mapping.LocationState;
import archipelagoon.icons.APIcon;
import io.github.archipelagomw.flags.NetworkItem;
import legend.game.inventory.InventoryEntry;
import legend.game.inventory.ItemIcon;
import org.legendofdragoon.modloader.registries.RegistryId;

public class APInventoryEntry implements InventoryEntry<APInventoryEntry> {
  public final Long locationId;
  public final int flags;
  public final String playerName;
  public final String itemName;
  public boolean isApplied;

  public APInventoryEntry(final LocationState locationState) {
    this.locationId = locationState.getLocationID();
    this.flags = locationState.getFlags();
    this.playerName = locationState.getPlayerName();
    this.itemName = locationState.getItemName();
    this.isApplied = locationState.isApplied();
  }

  @Override
  public RegistryId getRegistryId() {
    return null;
  }

  @Override
  public ItemIcon getIcon() {
    if((this.flags & NetworkItem.ADVANCEMENT) != 0) {
      return APIcon.PRIORITY;
    } else if((this.flags & NetworkItem.USEFUL) != 0) {
      return APIcon.USEFUL;
    } else if((this.flags & NetworkItem.TRAP) != 0) {
      return APIcon.PRIORITY; // trap icon can be determined later
    } else {
      return APIcon.FILLER;
    }
  }

  @Override
  public String getNameTranslationKey() {
    return this.itemName;
  }

  @Override
  public String getDescriptionTranslationKey() {
    return "archipelagoon.ap.item.description";
  }

  @Override
  public int getSize() {
    return 1;
  }

  @Override
  public int getMaxSize() {
    return 1;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }
}
