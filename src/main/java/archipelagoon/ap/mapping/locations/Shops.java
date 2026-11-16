package archipelagoon.ap.mapping.locations;

import legend.lodmod.LodShops;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Shops {
  private static final Map<RegistryId, Map<Integer, Long>> PERMA_SHOP_LOCATIONS = new LinkedHashMap<>();
  private static final Map<RegistryId, Map<Integer, Long>> MISSABLE_SHOP_LOCATIONS = new LinkedHashMap<>();
  private static final Map<RegistryId, Map<Integer, Long>> SHOP_LOCATIONS = new LinkedHashMap<>();

  static {
    final Long BASE_ID = 108_50000L;
    final ArrayList<RegistryId> permaShops = new ArrayList<>();
    permaShops.add(LodShops.BALE_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.SERDIO_ITEM_SHOP.getId());
    permaShops.add(LodShops.LOHAN_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.LOHAN_ITEM_SHOP.getId());
    permaShops.add(LodShops.KAZAS_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.KAZAS_FORT_ITEM_SHOP.getId());
    permaShops.add(LodShops.FLETZ_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.FLETZ_ITEM_SHOP.getId());
    permaShops.add(LodShops.DONAU_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.DONAU_ITEM_SHOP.getId());
    permaShops.add(LodShops.FUENO_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.FUENO_ITEM_SHOP.getId());
    permaShops.add(LodShops.FURNI_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.FURNI_ITEM_SHOP.getId());
    permaShops.add(LodShops.DENINGRAD_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.DENINGRAD_ITEM_SHOP.getId());
    permaShops.add(LodShops.WINGLY_FOREST_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.WINGLY_FOREST_ITEM_SHOP.getId());
    permaShops.add(LodShops.VELLWEB_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.VELLWEB_ITEM_SHOP.getId());
    permaShops.add(LodShops.ULARA_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.ULARA_ITEM_SHOP.getId());
    permaShops.add(LodShops.ROUGE_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.ROUGE_ITEM_SHOP.getId());
    permaShops.add(LodShops.MOON_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.MOON_ITEM_SHOP.getId());
    permaShops.add(LodShops.KASHUA_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.KASHUA_ITEM_SHOP.getId());
    permaShops.add(LodShops.FLETZ_ACCESSORY_SHOP.getId());
    permaShops.add(LodShops.KAZAS_FORT_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.ZENEBATOS_EQUIPMENT_SHOP.getId());
    permaShops.add(LodShops.ZENEBATOS_ITEM_SHOP.getId());

    final ArrayList<RegistryId> missableShops = new ArrayList<>();
    missableShops.add(LodShops.QUEEN_FURY_EQUIPMENT_SHOP.getId());
    missableShops.add(LodShops.QUEEN_FURY_ITEM_SHOP.getId());
    missableShops.add(LodShops.HELLENA_01_ITEM_SHOP.getId());
    missableShops.add(LodShops.FOREST_ITEM_SHOP.getId());
    missableShops.add(LodShops.VOLCANO_ITEM_SHOP.getId());
    missableShops.add(LodShops.HELLENA_02_ITEM_SHOP.getId());
    missableShops.add(LodShops.BLACK_CASTLE_ITEM_SHOP.getId());

    long currId = BASE_ID;
    for(final RegistryId shop : permaShops) {
      final Map<Integer, Long> slots = new HashMap<>();
      for(int i = 0; i < 20; i++) {
        slots.put(i, currId);
        currId++;
      }
      PERMA_SHOP_LOCATIONS.put(shop, slots);
    }

    for(final RegistryId shop : missableShops) {
      final Map<Integer, Long> slots = new HashMap<>();
      for(int i = 0; i < 20; i++) {
        slots.put(i, currId);
        currId++;
      }
      MISSABLE_SHOP_LOCATIONS.put(shop, slots);
    }
    SHOP_LOCATIONS.putAll(PERMA_SHOP_LOCATIONS);
    SHOP_LOCATIONS.putAll(MISSABLE_SHOP_LOCATIONS);
  }

  private Shops() {
  }

  public static Map<RegistryId, Map<Integer, Long>> getStaticMap() {
    return Collections.unmodifiableMap(SHOP_LOCATIONS);
  }

  public static List<Long> getLocationIds() {
    return SHOP_LOCATIONS.values().stream()
      .flatMap(locationMap -> locationMap.values().stream()).toList();
  }

  public static Collection<Long> getShopLocationIds(final RegistryId shopId) {
    return SHOP_LOCATIONS.get(shopId).values();
  }

  public static int getShopIndex(final RegistryId shopId) {
    int index = 0;
    for(final RegistryId key : SHOP_LOCATIONS.keySet()) {
      if(key.equals(shopId)) {
        break;
      }
      index++;
    }
    return index;
  }

  public static Long getLocationId(final RegistryId shopId, final int slotIndex) {
    final Map<Integer, Long> slots = SHOP_LOCATIONS.get(shopId);
    if(slots == null) {
      return null;
    }
    return slots.get(slotIndex);
  }

  public static boolean isPermanentShop(final RegistryId shopId) {
    return PERMA_SHOP_LOCATIONS.containsKey(shopId);
  }

  public static Set<Long> getStaticFlatMap() {
    final LinkedHashSet<Long> locationSet = new LinkedHashSet<>();
    for(final Map.Entry<RegistryId, Map<Integer, Long>> shopInfo : SHOP_LOCATIONS.entrySet()) {
      locationSet.addAll(shopInfo.getValue().values());
    }

    return Collections.unmodifiableSet(locationSet);
  }
}
