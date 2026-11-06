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
    CHEST_LOCATIONS.put(Submaps.BARRENS_FLETZ_EXIT, ChestData.barrens_fletz_exit_chests);
    CHEST_LOCATIONS.put(Submaps.BARRENS_DONAU_EXIT, ChestData.barrens_donau_exit_chests);
    CHEST_LOCATIONS.put(Submaps.VALLEY_OF_CORRUPTED_GRAVITY_FIREFLIES, ChestData.valley_area1_chests);
    CHEST_LOCATIONS.put(Submaps.VALLEY_OF_CORRUPTED_GRAVITY_FIRST_ROCKS, ChestData.valley_area2_chests);
    CHEST_LOCATIONS.put(Submaps.VALLEY_OF_CORRUPTED_GRAVITY_SAVE_ROOM, ChestData.valley_area4_chests);
    CHEST_LOCATIONS.put(Submaps.HOME_OF_GIGANTO_ENTRANCE, ChestData.gigantos_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.HOME_OF_GIGANTO_SWITCH, ChestData.gigantos_switch_room_chests);
    CHEST_LOCATIONS.put(Submaps.HOME_OF_GIGANTO_SAVE_ROOM, ChestData.gigantos_save_room_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_BOGY_ROOM, ChestData.phantom_ship_bogy_room_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_HALLWAY, ChestData.phantom_ship_hallway_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_PASSWORD_ROOM, ChestData.phantom_ship_password_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_CAPTAIN_ROOM, ChestData.phantom_ship_captain_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_PUZZLE, ChestData.phantom_ship_password_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_LOCKED_ROOM, ChestData.phantom_ship_locked_room_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_CRADLE, ChestData.phantom_ship_cradle_chests);
    CHEST_LOCATIONS.put(Submaps.LIDIERA_OUTSIDE, ChestData.lidiera_outside_chests);
    CHEST_LOCATIONS.put(Submaps.LIDIERA_CAVE, ChestData.lidiera_cave_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_BRIDGE, ChestData.undersea_cave_bridge_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_SECOND_ROOM, ChestData.undersea_cave_middle_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_WEST_ROOM, ChestData.undersea_cave_left_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_SAVE_ROOM, ChestData.undersea_cave_save_room_chests);
    CHEST_LOCATIONS.put(Submaps.FLETZ_TRAINING_ROOM, ChestData.fletz_training_chests);
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
