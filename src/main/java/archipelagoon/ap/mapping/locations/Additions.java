package archipelagoon.ap.mapping.locations;

import legend.lodmod.LodAdditions;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class Additions {
  private static final Map<RegistryId, Long> ADDITION_LOCATIONS = new LinkedHashMap<>();
  private static final Map<RegistryId, Long[]> ADDITION_LEVEL_LOCATIONS = new LinkedHashMap<>();

  static {
    final Long BASE_ID = 108_60000L;

    final ArrayList<RegistryId> additionUnlocks = new ArrayList<>();
    final ArrayList<RegistryId> dartAdditions = new ArrayList<>();
    dartAdditions.add(LodAdditions.DOUBLE_SLASH.getId());
    dartAdditions.add(LodAdditions.VOLCANO.getId());
    dartAdditions.add(LodAdditions.BURNING_RUSH.getId());
    dartAdditions.add(LodAdditions.CRUSH_DANCE.getId());
    dartAdditions.add(LodAdditions.MADNESS_HERO.getId());
    dartAdditions.add(LodAdditions.MOON_STRIKE.getId());
    dartAdditions.add(LodAdditions.BLAZING_DYNAMO.getId());

    final ArrayList<RegistryId> roseAdditions = new ArrayList<>();
    roseAdditions.add(LodAdditions.WHIP_SMACK.getId());
    roseAdditions.add(LodAdditions.MORE_MORE.getId());
    roseAdditions.add(LodAdditions.HARD_BLADE.getId());
    roseAdditions.add(LodAdditions.DEMONS_DANCE.getId());

    final ArrayList<RegistryId> lavitzAdditions = new ArrayList<>();
    lavitzAdditions.add(LodAdditions.HARPOON.getId());
    lavitzAdditions.add(LodAdditions.SPINNING_CANE.getId());
    lavitzAdditions.add(LodAdditions.ROD_TYPHOON.getId());
    lavitzAdditions.add(LodAdditions.GUST_OF_WIND_DANCE.getId());
    lavitzAdditions.add(LodAdditions.FLOWER_STORM.getId());

    final ArrayList<RegistryId> shanaAdditions = new ArrayList<>();

    final ArrayList<RegistryId> haschelAdditions = new ArrayList<>();
    haschelAdditions.add(LodAdditions.DOUBLE_PUNCH.getId());
    haschelAdditions.add(LodAdditions.FERRY_OF_STYX.getId());
    haschelAdditions.add(LodAdditions.SUMMON_4_GODS.getId());
    haschelAdditions.add(LodAdditions.FIVE_RING_SHATTERING.getId());
    haschelAdditions.add(LodAdditions.HEX_HAMMER.getId());
    haschelAdditions.add(LodAdditions.OMNI_SWEEP.getId());

    final ArrayList<RegistryId> albertAdditions = new ArrayList<>();
    albertAdditions.add(LodAdditions.ALBERT_HARPOON.getId());
    albertAdditions.add(LodAdditions.ALBERT_SPINNING_CANE.getId());
    albertAdditions.add(LodAdditions.ALBERT_ROD_TYPHOON.getId());
    albertAdditions.add(LodAdditions.ALBERT_GUST_OF_WIND_DANCE.getId());
    albertAdditions.add(LodAdditions.ALBERT_FLOWER_STORM.getId());

    final ArrayList<RegistryId> meruAdditions = new ArrayList<>();
    meruAdditions.add(LodAdditions.DOUBLE_SMACK.getId());
    meruAdditions.add(LodAdditions.HAMMER_SPIN.getId());
    meruAdditions.add(LodAdditions.COOL_BOOGIE.getId());
    meruAdditions.add(LodAdditions.CATS_CRADLE.getId());
    meruAdditions.add(LodAdditions.PERKY_STEP.getId());

    final ArrayList<RegistryId> kongolAdditions = new ArrayList<>();
    kongolAdditions.add(LodAdditions.PURSUIT.getId());
    kongolAdditions.add(LodAdditions.INFERNO.getId());
    kongolAdditions.add(LodAdditions.BONE_CRUSH.getId());

    final ArrayList<RegistryId> mirandaAdditions = new ArrayList<>();

    final ArrayList<RegistryId> startingAdditions = new ArrayList<>();
    startingAdditions.add(dartAdditions.getFirst());
    startingAdditions.add(lavitzAdditions.getFirst());
    //    startingAdditions.add(shanaAdditions.getFirst());
    startingAdditions.add(roseAdditions.getFirst());
    startingAdditions.add(haschelAdditions.getFirst());
    startingAdditions.add(albertAdditions.getFirst());
    startingAdditions.add(meruAdditions.getFirst());
    startingAdditions.add(kongolAdditions.getFirst());
    //    startingAdditions.add(mirandaAdditions.getFirst());

    final Map<String, ArrayList<RegistryId>> additionList = new LinkedHashMap<>();
    additionList.put("dart", dartAdditions);
    additionList.put("lavitz", lavitzAdditions);
    additionList.put("rose", roseAdditions);
    additionList.put("shana", shanaAdditions);
    additionList.put("haschel", haschelAdditions);
    additionList.put("albert", albertAdditions);
    additionList.put("meru", meruAdditions);
    additionList.put("kongol", kongolAdditions);
    additionList.put("miranda", mirandaAdditions);

    final ArrayList<RegistryId> unlockLocations = new ArrayList<>();
    final ArrayList<ArrayList<RegistryId>> masteryLocations = new ArrayList<>();
    for(final Map.Entry<String, ArrayList<RegistryId>> character : additionList.entrySet()) {
      for(final RegistryId id : character.getValue()) {
        final ArrayList<RegistryId> locs = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
          locs.add(id);
        }
        masteryLocations.add(locs);
        if(startingAdditions.contains(id)) {
          continue;
        }

        unlockLocations.add(id);
      }
    }

    long currId = BASE_ID;
    for(final RegistryId id : unlockLocations) {
      ADDITION_LOCATIONS.put(id, currId);
      currId++;
    }

    for(final ArrayList<RegistryId> ids : masteryLocations) {
      final ArrayList<Long> locs = new ArrayList<>();
      for(final RegistryId id : ids) {
        locs.add(currId);
        currId++;
      }
      ADDITION_LEVEL_LOCATIONS.put(ids.getFirst(), locs.toArray(new Long[] {}));
    }
  }

  private Additions() {
  }

  public static Map<RegistryId, Long> getStaticMap() {
    return Collections.unmodifiableMap(ADDITION_LOCATIONS);
  }

  public static Set<Long> getStaticFlatMap() {
    final LinkedHashSet<Long> locationSet = new LinkedHashSet<>(ADDITION_LOCATIONS.values());

    for(final Map.Entry<RegistryId, Long[]> additionLevelInfo : ADDITION_LEVEL_LOCATIONS.entrySet()) {
      locationSet.addAll(Arrays.asList(additionLevelInfo.getValue()));
    }

    return Collections.unmodifiableSet(new LinkedHashSet<>(locationSet));
  }

  public static Long getAPLocationId(final RegistryId additionId) {
    return ADDITION_LOCATIONS.get(additionId);
  }

  public static Long getAPLocationId(final RegistryId additionId, final int level) {
    return ADDITION_LEVEL_LOCATIONS.get(additionId)[level - 2];
  }
}
