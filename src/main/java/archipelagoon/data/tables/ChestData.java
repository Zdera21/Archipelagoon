package archipelagoon.data.tables;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ChestData {
  public static final Map<Integer, Long> seles_chests = new LinkedHashMap<>();
  public static final Map<Integer, Long> forest_chests = new LinkedHashMap<>();

  static{
    /* (primitive value, chest ID) */
    seles_chests.put(9, 108_40000L);

    forest_chests.put(4, 108_40001L);
    forest_chests.put(14, 108_40001L);
  }

  private ChestData(){}
}
