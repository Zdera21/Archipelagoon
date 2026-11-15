package archipelagoon.ap.mapping.locations;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

// PK - use this to look up item ID from AP item id
public final class Locations {
  private static final LinkedHashSet<Long> LOCATION_SET = new LinkedHashSet<>();

  static {
    LOCATION_SET.addAll(Additions.getStaticFlatMap());
    LOCATION_SET.addAll(Chests.getStaticFlatMap());
    LOCATION_SET.addAll(GoodsLocations.getStaticFlatMap());
    LOCATION_SET.addAll(Shops.getStaticFlatMap());
    LOCATION_SET.addAll(Enemies.getStaticFlatMap());
    LOCATION_SET.addAll(DragoonLevels.getStaticFlatMap());
  }

  private Locations() {
  }

  public static Set<Long> getStaticSet() {
    return Collections.unmodifiableSet(LOCATION_SET);
  }
}
