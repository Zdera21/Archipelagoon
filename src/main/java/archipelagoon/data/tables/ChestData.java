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

  static {
    /* (primitive value, chest ID) */
    seles_chests.put(9, 108_40000L);

    forest_merchant_chests.put(4, 108_40001L);
    forest_merchant_chests.put(14, 108_40001L);

    forest_tree_bridge_chests.put(6, 108_40002L);
    forest_tree_bridge_chests.put(12, 108_40002L);
    forest_tree_bridge_chests.put(35, 108_40002L);

    forest_maze_chests.put(51, 108_40003L);
    forest_maze_chests.put(52, 108_40003L);

    forest_maze_chests.put(14, 108_40004L);
    forest_maze_chests.put(53, 108_40004L);
    forest_maze_chests.put(54, 108_40004L);

    hellena_01_nw_entrance_chests.put(19, 108_40005L);

    hellena_barracks_chests.put(8, 108_40006L);
    hellena_barracks_chests.put(32, 108_40006L);
    hellena_barracks_chests.put(0, 108_40007L);
    hellena_barracks_chests.put(7, 108_40007L);
    hellena_barracks_chests.put(62, 108_40008L);
    hellena_barracks_chests.put(69, 108_40008L);

    hellena_jump_puzzle_chests.put(32, 108_40009L);

    hellena_tiny_cell_chests.put(17, 108_40010L);

    hellena_shana_tower_east_chests.put(12, 108_40011L);
    hellena_shana_tower_east_chests.put(13, 108_40011L);

    hellena_shana_tower_west_chests.put(9, 108_40012L);
    hellena_shana_tower_west_chests.put(15, 108_40012L);
    hellena_shana_tower_west_chests.put(16, 108_40012L);

    prairie_rock_arch_chests.put(1, 108_40013L);

    prairie_shack_chests.put(10, 108_40014L);

    prairie_before_cave.put(1, 108_40015L);
    prairie_before_cave.put(26, 108_40015L);
  }

  private ChestData() {
  }
}
