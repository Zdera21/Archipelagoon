package archipelagoon.ap.mapping.locations;

import legend.lodmod.LodCharacterTemplates;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class DragoonLevels {
  private static final Map<RegistryId, Map<Integer, Long>> CHARACTER_MAGIC_LOCATIONS = new LinkedHashMap<>();

  static {
    final Map<Integer, Long> dart_levels = new LinkedHashMap<>();
    dart_levels.put(2, 108_90001L);
    dart_levels.put(3, 108_90002L);
    dart_levels.put(4, 108_90003L);
    dart_levels.put(5, 108_90004L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.DART.getId(), dart_levels);

    final Map<Integer, Long> lavitz_spells = new LinkedHashMap<>();
    lavitz_spells.put(2, 108_90011L);
    lavitz_spells.put(3, 108_90012L);
    lavitz_spells.put(4, 108_90013L);
    lavitz_spells.put(5, 108_90014L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.LAVITZ.getId(), lavitz_spells);

    final Map<Integer, Long> shana_spells = new LinkedHashMap<>();
    shana_spells.put(2, 108_90021L);
    shana_spells.put(3, 108_90022L);
    shana_spells.put(4, 108_90023L);
    shana_spells.put(5, 108_90024L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.SHANA.getId(), shana_spells);

    final Map<Integer, Long> rose_spells = new LinkedHashMap<>();
    rose_spells.put(2, 108_90031L);
    rose_spells.put(3, 108_90032L);
    rose_spells.put(4, 108_90033L);
    rose_spells.put(5, 108_90034L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.ROSE.getId(), rose_spells);

    final Map<Integer, Long> haschel_spells = new LinkedHashMap<>();
    haschel_spells.put(2, 108_90041L);
    haschel_spells.put(3, 108_90042L);
    haschel_spells.put(4, 108_90043L);
    haschel_spells.put(5, 108_90044L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.HASCHEL.getId(), haschel_spells);

    final Map<Integer, Long> albert_spells = new LinkedHashMap<>();
    albert_spells.put(2, 108_90051L);
    albert_spells.put(3, 108_90052L);
    albert_spells.put(4, 108_90053L);
    albert_spells.put(5, 108_90054L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.ALBERT.getId(), albert_spells);

    final Map<Integer, Long> meru_spells = new LinkedHashMap<>();
    meru_spells.put(2, 108_90061L);
    meru_spells.put(3, 108_90062L);
    meru_spells.put(4, 108_90063L);
    meru_spells.put(5, 108_90064L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.MERU.getId(), meru_spells);

    final Map<Integer, Long> kongol_spells = new LinkedHashMap<>();
    kongol_spells.put(2, 108_90071L);
    kongol_spells.put(3, 108_90072L);
    kongol_spells.put(4, 108_90073L);
    kongol_spells.put(5, 108_90074L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.KONGOL.getId(), kongol_spells);

    final Map<Integer, Long> miranda_spells = new LinkedHashMap<>();
    miranda_spells.put(2, 108_90081L);
    miranda_spells.put(3, 108_90082L);
    miranda_spells.put(4, 108_90083L);
    miranda_spells.put(5, 108_90084L);
    CHARACTER_MAGIC_LOCATIONS.put(LodCharacterTemplates.MIRANDA.getId(), miranda_spells);

    final Map<Integer, Long> lloyd_spells = new LinkedHashMap<>();
    lloyd_spells.put(2, 108_90091L);
    lloyd_spells.put(3, 108_90092L);
    lloyd_spells.put(4, 108_90093L);
    lloyd_spells.put(5, 108_90094L);
    CHARACTER_MAGIC_LOCATIONS.put(new RegistryId("lloyd_mod", "lloyd"), lloyd_spells);
  }

  private DragoonLevels() {
  }

  public static Map<RegistryId, Map<Integer, Long>> getStaticMap() {
    return Collections.unmodifiableMap(CHARACTER_MAGIC_LOCATIONS);
  }

  public static Long getLocationId(final RegistryId charId, final int level) {
    try {
      return CHARACTER_MAGIC_LOCATIONS.get(charId).getOrDefault(level, -1L);
    } catch(final Exception e) {
      return -1L;
    }
  }

  public static Set<Long> getStaticFlatMap() {
    final LinkedHashSet<Long> locationSet = new LinkedHashSet<>();
    for(final Map.Entry<RegistryId, Map<Integer, Long>> magicInfo : CHARACTER_MAGIC_LOCATIONS.entrySet()) {
      locationSet.addAll(magicInfo.getValue().values());
    }

    return Collections.unmodifiableSet(locationSet);
  }
}
