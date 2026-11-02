package archipelagoon.ap.mapping.locations;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

// PK - use this to look up item ID from AP item id
public final class Locations {
  private static final Map<Long, String> LOCATION_MAP = new LinkedHashMap<>();
  private static final Map<String, Long> LOCATION_MAP_REVERSE = new LinkedHashMap<>();

  static {
    LOCATION_MAP.putAll(Additions.getStaticFlatMap());
    LOCATION_MAP.putAll(Chests.getStaticStringMap());
    LOCATION_MAP.putAll(GoodsLocations.getStaticStringMap());
    LOCATION_MAP.putAll(Shops.getStaticFlatMap());
    LOCATION_MAP.putAll(Enemies.getStaticMap());
    LOCATION_MAP.putAll(DragoonLevels.getStaticFlatMap());

    for(final Map.Entry<Long, String> entry : LOCATION_MAP.entrySet()) {
      LOCATION_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }
  }

  private Locations() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(LOCATION_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(LOCATION_MAP_REVERSE);
  }

  public static Long getAPLocationIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.toString());
  }

  public static String getRegistryIdFromAPLocationId(final Long LocationId) {
    return getStaticMap().get(LocationId);
  }
}
