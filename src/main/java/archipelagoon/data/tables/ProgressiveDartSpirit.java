package archipelagoon.data.tables;

import legend.lodmod.LodGoods;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ProgressiveDartSpirit {
  private static final Map<Integer, RegistryId> DART_PROGRESSIVE_SPIRIT_MAP = new LinkedHashMap<>();

  static {
    DART_PROGRESSIVE_SPIRIT_MAP.put(1, LodGoods.FATHERS_STONE.getId());
    DART_PROGRESSIVE_SPIRIT_MAP.put(2, LodGoods.RED_DRAGOON_SPIRIT.getId());
    DART_PROGRESSIVE_SPIRIT_MAP.put(3, LodGoods.DIVINE_DRAGOON_SPIRIT.getId());
  }

  private ProgressiveDartSpirit() {
  }

  public static Map<Integer, RegistryId> getStaticMap() {
    return Collections.unmodifiableMap(DART_PROGRESSIVE_SPIRIT_MAP);
  }
}


