package archipelagoon.icons;

import legend.game.inventory.ItemIcon;
import legend.game.types.UiType;

public class APIcon extends ItemIcon {
  public static final APIcon PRIORITY = new APIcon(0);
  public static final APIcon USEFUL = new APIcon(1);
  public static final APIcon FILLER = new APIcon(2);

  public APIcon(final int icon) {
    super(icon);
  }

  @Override
  protected UiType getUiType() {
    return APIconUiType._ICONS;
  }
}
