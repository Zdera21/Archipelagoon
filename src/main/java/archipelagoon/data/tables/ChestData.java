package archipelagoon.data.tables;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ChestData {
  public static final Map<Integer, Long> seles_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> forest_merchant_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> forest_tree_bridge_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> forest_maze_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> hellena_01_nw_entrance_chests = new LinkedHashMap<>();

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
  }

  private ChestData() {
  }
}
