package archipelagoon.ap.mapping.locations;

import archipelagoon.data.enums.Submaps;
import archipelagoon.data.tables.ChestData;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Chests {
  private static final Map<Integer, Map<Integer, Long>> CHEST_LOCATIONS = new LinkedHashMap<>();

  static {
    //    final Long BASE_ID = 108_40000L;
    CHEST_LOCATIONS.put(Submaps.SELES_FENCE_AREA, ChestData.seles_chests);
    CHEST_LOCATIONS.put(Submaps.FOREST_MERCHANT, ChestData.forest_merchant_chests);
    CHEST_LOCATIONS.put(Submaps.FOREST_TREE_BRIDGE, ChestData.forest_tree_bridge_chests);
    CHEST_LOCATIONS.put(Submaps.FOREST_MAZE, ChestData.forest_maze_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_PRISON_NORTHWEST_ENTRANCE, ChestData.hellena_01_nw_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_BARRACKS_ELEVATOR, ChestData.hellena_barracks_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_JUMP_PUZZLE, ChestData.hellena_jump_puzzle_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_TINY_CELL, ChestData.hellena_tiny_cell_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_SHANA_EAST_CELL, ChestData.hellena_shana_tower_east_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_SHANA_WEST_CELL, ChestData.hellena_shana_tower_west_chests);
    CHEST_LOCATIONS.put(Submaps.PRAIRIE_SHACK_OUTSIDE, ChestData.prairie_shack_chests);
    CHEST_LOCATIONS.put(Submaps.PRAIRIE_COAST_BEFORE_TREE, ChestData.prairie_rock_arch_chests);
    CHEST_LOCATIONS.put(Submaps.PRAIRIE_OUTSIDE_OF_CAVE, ChestData.prairie_before_cave);
  }

  private Chests() {
  }

  public static Map<Integer, Map<Integer, Long>> getStaticMap() {
    return Collections.unmodifiableMap(CHEST_LOCATIONS);
  }

  public static Map<Long, String> getStaticStringMap() {
    final Map<Long, String> locationMap = new LinkedHashMap<>();
    for(final Map.Entry<Integer, Map<Integer, Long>> areaInfo : CHEST_LOCATIONS.entrySet()) {
      for(final Map.Entry<Integer, Long> chestInfo : areaInfo.getValue().entrySet()) {
        locationMap.put(chestInfo.getValue(), String.valueOf(chestInfo.getKey()));
      }
    }

    return Collections.unmodifiableMap(locationMap);
  }

  public static Long getAPLocationId(final int submap, final int objectIndex) {
    try {
      return getStaticMap().get(submap).getOrDefault(objectIndex, -1L);
    } catch(final Exception e) {
      return -1L;
    }
  }
}
