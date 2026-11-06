package archipelagoon.data.tables;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ChestData {
  public static final Map<Integer, Long> seles_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> forest_merchant_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> forest_tree_bridge_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> forest_maze_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> hellena_01_nw_entrance_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> hellena_barracks_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> hellena_jump_puzzle_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> hellena_tiny_cell_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> hellena_shana_tower_east_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> hellena_shana_tower_west_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> prairie_rock_arch_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> prairie_shack_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> prairie_before_cave = new LinkedHashMap<>();

  public static final Map<Integer,Long> barrens_fletz_exit_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> barrens_donau_exit_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> valley_area1_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> valley_area2_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> valley_area4_chests = new LinkedHasMap<>();  
  public static final Map<Integer,Long> gigantos_entrance_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> gigantos_switch_room_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> gigantos_save_room_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> phantom_ship_bogy_room_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> phantom_ship_hallway_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> phantom_ship_password_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> phantom_ship_captain_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> phantom_ship_puzzle_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> phantom_ship_locked_room_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> phantom_ship_cradle_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> lidiera_outside_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> lidiera_cave_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> undersea_cave_bridge_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> undersea_cave_middle_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> undersea_cave_left_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> undersea_cave_save_room_chests = new LinkedHasMap<>();
  public static final Map<Integer,Long> fletz_training_chests = new LinkedHasMap<>();

  static {
    /* (script index, chest ID) */
    seles_chests.put(8, 108_40000L);

    forest_merchant_chests.put(7, 108_40001L);

    forest_tree_bridge_chests.put(3, 108_40002L);

    forest_maze_chests.put(7, 108_40003L);

    forest_maze_chests.put(8, 108_40004L);

    hellena_01_nw_entrance_chests.put(1, 108_40005L);

    hellena_barracks_chests.put(4, 108_40006L);
    hellena_barracks_chests.put(6, 108_40007L);
    hellena_barracks_chests.put(5, 108_40008L);

    hellena_jump_puzzle_chests.put(1, 108_40009L);

    hellena_tiny_cell_chests.put(3, 108_40010L);

    hellena_shana_tower_east_chests.put(2, 108_40011L);

    hellena_shana_tower_west_chests.put(3, 108_40012L);

    prairie_rock_arch_chests.put(13, 108_40013L);

    prairie_shack_chests.put(5, 108_40014L);

    prairie_before_cave.put(7, 108_40015L);


    barrens_fletz_exit_chests.put(2, 108_40108L)

    barrens_donau_exit_chests.put(1, 108_40109L)
    barrens_donau_exit_chests.put(2, 108_40110L)

    valley_area1_chests.put(9, 108_40111L)
    valley_area1_chests.put(10, 108_40112L)

    valley_area2_chests.put(12, 108_40113L)

    valley_area4_chests.put(14, 108_40114L)
    valley_area4_chests.put(13, 108_40115L)

    gigantos_entrance_chests.put(7, 108_40116L)
    gigantos_entrance_chests.put(8, 108_40118L)

    gigantos_switch_room_chests.put(7, 108_40117L)

    gigantos_save_room_chests.put(7, 108_40119L)

    phantom_ship_bogy_room_chests.put(1, 108_40120L)
    phantom_ship_bogy_room_chests.put(1, 108_40122L) /* ??? */

    phantom_ship_hallway_chests.put(2, 108_40121L)

    phantom_ship_password_chests.put(5, 108_40123L)
    phantom_ship_password_chests.put(1, 108_40124L) /* Bogy chest */

    phantom_ship_captain_chests.put(9, 108_40125L)
    phantom_ship_captain_chests.put(8, 108_40126L)

    phantom_ship_puzzle_chests.put(1, 108_40127L) /*
    phantom_ship_puzzle_chests.put(1, 108_40128L)
    phantom_ship_puzzle_chests.put(1, 108_40129L)  puzzle chest levels
    phantom_ship_puzzle_chests.put(1, 108_40130L)
    phantom_ship_puzzle_chests.put(1, 108_40131L)
    phantom_ship_puzzle_chests.put(1, 108_40132L) */

    phantom_ship_locked_room_chests.put(12, 108_40133L)

    phantom_ship_cradle_chests.put(9, 108_40134L)

    lidiera_outside_chests.put(10, 108_40135L)

    lidiera_cave_chests.put(2, 108_40136L)
    lidiera_cave_chests.put(1, 108_40137L)

    undersea_cave_bridge_chests.put(7, 108_40138L)

    undersea_cave_middle_chests.put(2, 108_40139L)
    undersea_cave_middle_chests.put(1, 108_40140L)

    undersea_cave_left_chests.put(1, 108_40141L)
    undersea_cave_left_chests.put(2, 108_40142L)

    undersea_cave_save_room_chests.put(1, 108_40143L)
    undersea_cave_save_room_chests.put(2, 108_40144L)

    fletz_training_chests.put(9, 108_40145L)
    fletz_training_chests.put(8, 108_40146L)


  }

  private ChestData() {
  }
}
