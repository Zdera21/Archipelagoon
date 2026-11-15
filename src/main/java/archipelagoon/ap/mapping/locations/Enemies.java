package archipelagoon.ap.mapping.locations;

import legend.lodmod.LodEncounters;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class Enemies {
  private static final Map<Long, RegistryId> ENEMY_LOCATIONS = new LinkedHashMap<>();
  private static final Map<RegistryId, Long> ENEMY_LOCATIONS_REVERSE = new LinkedHashMap<>();

  static {
    ENEMY_LOCATIONS.put(108_70001L, LodEncounters.ENCOUNTER_SELES_COMMANDER.getId());
    ENEMY_LOCATIONS.put(108_70002L, LodEncounters.ENCOUNTER_FRUEGEL_HELLENA_WARDEN_HELLENA_WARDEN_SENIOR_WARDEN_SENIOR_WARDEN.getId());
    ENEMY_LOCATIONS.put(108_70003L, LodEncounters.ENCOUNTER_UROBOLUS.getId());
    ENEMY_LOCATIONS.put(108_70004L, LodEncounters.ENCOUNTER_SANDORA_ELITE_SANDORA_ELITE_SANDORA_ELITE.getId());
    ENEMY_LOCATIONS.put(108_70005L, LodEncounters.ENCOUNTER_KONGOL.getId());
    ENEMY_LOCATIONS.put(108_70006L, LodEncounters.ENCOUNTER_VIRAGE_HEAD_VIRAGE_BODY_VIRAGE_ARM_.getId());
    ENEMY_LOCATIONS.put(108_70007L, LodEncounters.ENCOUNTER_FIRE_BIRD.getId());
    ENEMY_LOCATIONS.put(108_70008L, LodEncounters.ENCOUNTER_FEYRBRAND_GREHAM.getId());
    ENEMY_LOCATIONS.put(108_70009L, LodEncounters.ENCOUNTER_DRAKE_THE_BANDIT.getId());
    ENEMY_LOCATIONS.put(108_70010L, LodEncounters.ENCOUNTER_SHIRLEY_SHANA_ALBERT.getId());
    ENEMY_LOCATIONS.put(108_70011L, LodEncounters.ENCOUNTER_GORGAGA.getId());
    ENEMY_LOCATIONS.put(108_70012L, LodEncounters.ENCOUNTER_SERFIUS.getId());
    ENEMY_LOCATIONS.put(108_70013L, LodEncounters.ENCOUNTER_DANTON.getId());
    ENEMY_LOCATIONS.put(108_70014L, LodEncounters.ENCOUNTER_ATLOW.getId());
    ENEMY_LOCATIONS.put(108_70015L, LodEncounters.ENCOUNTER_LLOYD.getId());
    ENEMY_LOCATIONS.put(108_70016L, LodEncounters.ENCOUNTER_FRUEGEL_RODRIGUEZ_GUFTAS.getId());
    ENEMY_LOCATIONS.put(108_70017L, LodEncounters.ENCOUNTER_KONGOL_1.getId());
    ENEMY_LOCATIONS.put(108_70018L, LodEncounters.ENCOUNTER_EMPEROR_DOEL_DRAGOON_DOEL.getId());
    ENEMY_LOCATIONS.put(108_70019L, LodEncounters.ENCOUNTER_MAPPI_CRAFTY_THIEF_CRAFTY_THIEF.getId());
    ENEMY_LOCATIONS.put(108_70020L, LodEncounters.ENCOUNTER_VIRAGE_HEAD_VIRAGE_BODY_VIRAGE_ARM_VIRAGE_ARM_.getId());
    ENEMY_LOCATIONS.put(108_70021L, LodEncounters.ENCOUNTER_MAPPI_GEHRICH.getId());
    ENEMY_LOCATIONS.put(108_70022L, LodEncounters.ENCOUNTER_LENUS.getId());
    ENEMY_LOCATIONS.put(108_70023L, LodEncounters.ENCOUNTER_GHOST_COMMANDER_GHOST_KNIGHT_GHOST_KNIGHT_GHOST_KNIGHT_GHOST_KNIGHT.getId());
    ENEMY_LOCATIONS.put(108_70024L, LodEncounters.ENCOUNTER_LENUS_REGOLE.getId());
    ENEMY_LOCATIONS.put(108_70025L, LodEncounters.ENCOUNTER_S_VIRAGE_HEAD_S_VIRAGE_BODY_S_VIRAGE_ARM_.getId());
    ENEMY_LOCATIONS.put(108_70026L, LodEncounters.ENCOUNTER_GRAND_JEWEL.getId());
    ENEMY_LOCATIONS.put(108_70027L, LodEncounters.ENCOUNTER_DIVINE_DRAGON_DIVINE_CANNON_DIVINE_BALL.getId());
    ENEMY_LOCATIONS.put(108_70028L, LodEncounters.ENCOUNTER_WINDIGO.getId());
    ENEMY_LOCATIONS.put(108_70029L, LodEncounters.ENCOUNTER_LLOYD_DUMMY_LLOYD.getId());
    ENEMY_LOCATIONS.put(108_70030L, LodEncounters.ENCOUNTER_POLTER_HELM_POLTER_ARMOR_POLTER_SWORD.getId());
    ENEMY_LOCATIONS.put(108_70031L, LodEncounters.ENCOUNTER_LAST_KRAKEN.getId());
    ENEMY_LOCATIONS.put(108_70032L, LodEncounters.ENCOUNTER_MAGICIAN_FAUST_MAZO_MAZO_MAZO_MAZO.getId());
    ENEMY_LOCATIONS.put(108_70033L, LodEncounters.ENCOUNTER_BELZAC.getId());
    ENEMY_LOCATIONS.put(108_70034L, LodEncounters.ENCOUNTER_DAMIA.getId());
    ENEMY_LOCATIONS.put(108_70035L, LodEncounters.ENCOUNTER_KANZAS.getId());
    ENEMY_LOCATIONS.put(108_70036L, LodEncounters.ENCOUNTER_SYUVEIL.getId());
    ENEMY_LOCATIONS.put(108_70037L, LodEncounters.ENCOUNTER_VECTOR_SELEBUS_KUBILA.getId());
    ENEMY_LOCATIONS.put(108_70038L, LodEncounters.ENCOUNTER_GHOSTFB_DRAGON_SPIRIT.getId());
    ENEMY_LOCATIONS.put(108_70039L, LodEncounters.ENCOUNTER_GHOST_REGOLE_DRAGON_SPIRIT.getId());
    ENEMY_LOCATIONS.put(108_70040L, LodEncounters.ENCOUNTER_DIVINE_DRAGOON_GHOST_DRAGON_SPIRIT.getId());
    ENEMY_LOCATIONS.put(108_70041L, LodEncounters.ENCOUNTER_ZACKWELL_LAVITZS_SPIRIT.getId());
    ENEMY_LOCATIONS.put(108_70042L, LodEncounters.ENCOUNTER_CATERPILLAR_PUPA_IMAGO.getId());
    ENEMY_LOCATIONS.put(108_70043L, LodEncounters.ENCOUNTER_MICHAEL_MICHAEL_CORE_.getId());
    ENEMY_LOCATIONS.put(108_70044L, LodEncounters.ENCOUNTER_S_VIRAGE_HEAD_S_VIRAGE_ARM_S_VIRAGE_BODY_.getId());
    ENEMY_LOCATIONS.put(108_70045L, LodEncounters.ENCOUNTER_ZIEG_FELD_MISSING.getId());
    ENEMY_LOCATIONS.put(108_70047L, LodEncounters.ENCOUNTER_JIANGO.getId());
    ENEMY_LOCATIONS.put(108_70048L, LodEncounters.ENCOUNTER_KAMUY.getId());
    ENEMY_LOCATIONS.put(108_70049L, LodEncounters.ENCOUNTER_SANDORA_SOLDIER_COMMANDER_SANDORA_SOLDIER.getId());
    ENEMY_LOCATIONS.put(108_70050L, LodEncounters.ENCOUNTER_SANDORA_ELITE.getId());
    ENEMY_LOCATIONS.put(108_70051L, LodEncounters.ENCOUNTER_DEATH_ROSE.getId());
    ENEMY_LOCATIONS.put(108_70052L, LodEncounters.ENCOUNTER_CLAIRE_CLAIRE.getId());
    ENEMY_LOCATIONS.put(108_70053L, LodEncounters.ENCOUNTER_INDORA.getId());
    ENEMY_LOCATIONS.put(108_70054L, LodEncounters.ENCOUNTER_DARK_DOEL_LIGHT_SWORD_SHADOW_BLADE.getId());
    ENEMY_LOCATIONS.put(108_70055L, LodEncounters.ENCOUNTER_ARCHANGEL.getId());

    for(final Map.Entry<Long, RegistryId> entry : ENEMY_LOCATIONS.entrySet()) {
      ENEMY_LOCATIONS_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert ENEMY_LOCATIONS.size() == ENEMY_LOCATIONS_REVERSE.size();
  }

  private Enemies() {
  }

  public static Map<Long, RegistryId> getStaticMap() {
    return Collections.unmodifiableMap(ENEMY_LOCATIONS);
  }

  public static Map<RegistryId, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(ENEMY_LOCATIONS_REVERSE);
  }

  public static Long getAPLocationIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().getOrDefault(registryId, -1L);
  }

  public static Set<Long> getStaticFlatMap() {
    return Collections.unmodifiableSet(ENEMY_LOCATIONS.keySet());
  }
}
