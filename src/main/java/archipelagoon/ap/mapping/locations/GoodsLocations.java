package archipelagoon.ap.mapping.locations;

import legend.lodmod.LodGoods;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class GoodsLocations {
  private static final Map<RegistryId, Long> GOOD_LOCATIONS = new LinkedHashMap<>();

  static {
    GOOD_LOCATIONS.put(LodGoods.RED_DRAGOON_SPIRIT.getId(), 108_80001L);
    GOOD_LOCATIONS.put(LodGoods.BLUE_DRAGOON_SPIRIT.getId(), 108_80002L);
    GOOD_LOCATIONS.put(LodGoods.JADE_DRAGOON_SPIRIT.getId(), 108_80003L);
    GOOD_LOCATIONS.put(LodGoods.GOLD_DRAGOON_SPIRIT.getId(), 108_80004L);
    GOOD_LOCATIONS.put(LodGoods.VIOLET_DRAGOON_SPIRIT.getId(), 108_80005L);
    GOOD_LOCATIONS.put(LodGoods.SILVER_DRAGOON_SPIRIT.getId(), 108_80006L);
    GOOD_LOCATIONS.put(LodGoods.DARK_DRAGOON_SPIRIT.getId(), 108_80007L);
    GOOD_LOCATIONS.put(LodGoods.DIVINE_DRAGOON_SPIRIT.getId(), 108_80008L);
    GOOD_LOCATIONS.put(LodGoods.PRISON_KEY.getId(), 108_80011L);
    GOOD_LOCATIONS.put(LodGoods.AXE_FROM_THE_SHACK.getId(), 108_80012L);
    GOOD_LOCATIONS.put(LodGoods.GOOD_SPIRITS.getId(), 108_80013L);
    GOOD_LOCATIONS.put(LodGoods.SHINY_BAG.getId(), 108_80014L);
    GOOD_LOCATIONS.put(LodGoods.WATER_BOTTLE.getId(), 108_80015L);
    GOOD_LOCATIONS.put(LodGoods.LIFE_WATER.getId(), 108_80016L);
    GOOD_LOCATIONS.put(LodGoods.MAGIC_OIL.getId(), 108_80017L);
    GOOD_LOCATIONS.put(LodGoods.YELLOW_STONE.getId(), 108_80018L);
    GOOD_LOCATIONS.put(LodGoods.BLUE_STONE.getId(), 108_80019L);
    GOOD_LOCATIONS.put(LodGoods.RED_STONE.getId(), 108_80020L);
    GOOD_LOCATIONS.put(LodGoods.LETTER_FROM_LYNN.getId(), 108_80021L);
    GOOD_LOCATIONS.put(LodGoods.PASS_FOR_VALLEY.getId(), 108_80022L);
    GOOD_LOCATIONS.put(LodGoods.KATES_BOUQUET.getId(), 108_80023L);
    GOOD_LOCATIONS.put(LodGoods.KEY_TO_SHIP.getId(), 108_80024L);
    GOOD_LOCATIONS.put(LodGoods.BOAT_LICENSE.getId(), 108_80025L);
    GOOD_LOCATIONS.put(LodGoods.DRAGON_BLOCKER.getId(), 108_80026L);
    GOOD_LOCATIONS.put(LodGoods.MOON_GEM.getId(), 108_80027L);
    GOOD_LOCATIONS.put(LodGoods.MOON_DAGGER.getId(), 108_80028L);
    GOOD_LOCATIONS.put(LodGoods.MOON_MIRROR.getId(), 108_80029L);
    GOOD_LOCATIONS.put(LodGoods.VANISHING_STONE.getId(), 108_80036L);
    GOOD_LOCATIONS.put(LodGoods.LAVITZS_PICTURE.getId(), 108_80037L);
  }

  private GoodsLocations() {
  }

  public static Map<RegistryId, Long> getStaticMap() {
    return Collections.unmodifiableMap(GOOD_LOCATIONS);
  }

  public static Long getAPLocationId(final RegistryId registryId) {
    return getStaticMap().getOrDefault(registryId, -1L);
  }

  public static Set<Long> getStaticFlatMap() {

    final LinkedHashSet<Long> locationSet = new LinkedHashSet<>(GOOD_LOCATIONS.values());
    return Collections.unmodifiableSet(locationSet);
  }
}
