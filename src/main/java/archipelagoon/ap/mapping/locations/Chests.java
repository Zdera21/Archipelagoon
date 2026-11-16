package archipelagoon.ap.mapping.locations;

import archipelagoon.data.enums.Submaps;
import archipelagoon.data.tables.ChestData;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

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
    CHEST_LOCATIONS.put(Submaps.PRAIRIE_OUTSIDE_OF_CAVE, ChestData.prairie_before_cave_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_ENTRY, ChestData.limestone_cave_entry_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_WATERSLIDE, ChestData.limestone_cave_waterslide_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_HOPPING_ROCKS_ROOM, ChestData.limestone_cave_hopping_rocks_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_FROG_ROOM, ChestData.limestone_cave_frog_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_ROCK_FIREFLIES_ROOM, ChestData.limestone_cave_rock_fireflies_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_STONE_BRIDGE_ROOM, ChestData.limestone_cave_stone_bridge_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_SAVE_ROOM, ChestData.limestone_cave_save_room_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_WINDING_TUNNEL, ChestData.limestone_cave_winding_tunnel_chests);
    CHEST_LOCATIONS.put(Submaps.BALE_ARTIST_HOUSE, ChestData.bale_artist_chests);
    CHEST_LOCATIONS.put(Submaps.BALE_CASTLE_FIRST_FLOOR, ChestData.bale_castle_1st_floor_chests);
    CHEST_LOCATIONS.put(Submaps.BALE_CASTLE_SECOND_FLOOR, ChestData.bale_castle_2nd_floor_chests);
    CHEST_LOCATIONS.put(Submaps.BALE_CASTLE_THIRD_FLOOR, ChestData.bale_castle_3rd_floor_chests);
    CHEST_LOCATIONS.put(Submaps.BALE_LAVITZ_KITCHEN, ChestData.bale_lavitz_chests);
    CHEST_LOCATIONS.put(Submaps.BALE_BARN, ChestData.bale_barn_chests);
    CHEST_LOCATIONS.put(Submaps.BALE_UNDERGROUND_HALL, ChestData.bale_underground_hall_chests);
    CHEST_LOCATIONS.put(Submaps.HOAX_INN, ChestData.hoax_inn_chests);
    CHEST_LOCATIONS.put(Submaps.HOAX_GUARD_ROOM, ChestData.hoax_guard_room_chests);
    CHEST_LOCATIONS.put(Submaps.HOAX_NURSE_ATTIC, ChestData.hoax_nurse_attic_chests);
    CHEST_LOCATIONS.put(Submaps.MARSHLAND_OUTSIDE_FORT, ChestData.marshland_outside_fort_chests);
    CHEST_LOCATIONS.put(Submaps.MARSHLAND_FORT, ChestData.marshland_fort_chests);
    CHEST_LOCATIONS.put(Submaps.MARSHLAND_EAST_SWAMP, ChestData.marshland_east_swamp_chests);
    CHEST_LOCATIONS.put(Submaps.MARSHLAND_WEST_SWAMP, ChestData.marshland_west_swamp_chests);
    CHEST_LOCATIONS.put(Submaps.VOLCANO_AREA_2, ChestData.volcano_area_2_chests);
    CHEST_LOCATIONS.put(Submaps.VOLCANO_AREA_3, ChestData.volcano_area_3_chests);
    CHEST_LOCATIONS.put(Submaps.VOLCANO_CLIFF, ChestData.volcano_east_cliff_chests);
    CHEST_LOCATIONS.put(Submaps.VOLCANO_DABAS, ChestData.volcano_dabas_chests);
    CHEST_LOCATIONS.put(Submaps.NEST_OF_DRAGON_STREAM_1, ChestData.nest_of_dragon_stream_chests);
    CHEST_LOCATIONS.put(Submaps.NEST_OF_DRAGON_LIFE_WATER, ChestData.nest_of_dragon_pool_chests);
    CHEST_LOCATIONS.put(Submaps.NEST_OF_DRAGON_SAVE_ROOM, ChestData.nest_of_dragon_save_room_chests);
    CHEST_LOCATIONS.put(Submaps.LOHAN_INN, ChestData.lohan_inn_chests);
    CHEST_LOCATIONS.put(Submaps.LOHAN_OUTSIDE_SHOPS, ChestData.lohan_outside_shops_chests);
    CHEST_LOCATIONS.put(Submaps.LOHAN_OUTSIDE_ARENA, ChestData.lohan_outside_arena_chests);
    CHEST_LOCATIONS.put(Submaps.SHRINE_OF_SHIRLEY_ENTRANCE, ChestData.shrine_of_shirley_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.SHRINE_OF_SHIRLEY_WEST_ROOM, ChestData.shrine_of_shirley_west_chests);
    CHEST_LOCATIONS.put(Submaps.SHRINE_OF_SHIRLEY_EAST_ROOM, ChestData.shrine_of_shirley_east_chests);
    CHEST_LOCATIONS.put(Submaps.SHRINE_OF_SHIRLEY_STATUES, ChestData.shrine_of_shirley_cart_chests);
    CHEST_LOCATIONS.put(Submaps.SHRINE_OF_SHIRLEY_APEX, ChestData.shrine_of_shirley_apex_chests);
    CHEST_LOCATIONS.put(Submaps.SHRINE_OF_SHIRLEY_TREASURE_ROOM, ChestData.shrine_of_shirley_treasure_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_LADDER_ROOM, ChestData.hellena_ladder_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_ELEVATOR_ROOM, ChestData.hellena_elevator_room_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_TRAP_DOOR, ChestData.hellena_trapdoor_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_DUNGEON, ChestData.hellena_dungeon_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_JIANGO_STAIRS, ChestData.hellena_jiango_stairs_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_APEX_SAVE_ROOM, ChestData.hellena_apex_chests);
    CHEST_LOCATIONS.put(Submaps.KAZAS_RECRUITER_ROOM, ChestData.kazas_recruiter_chests);
    CHEST_LOCATIONS.put(Submaps.KAZAS_WEAPON_STORE, ChestData.kazas_storage_house_chests);
    CHEST_LOCATIONS.put(Submaps.KAZAS_TUNNELS, ChestData.kazas_tunnels_chests);
    CHEST_LOCATIONS.put(Submaps.BLACK_CASTLE_UNDERGROUND, ChestData.black_castle_underground_chests);
    CHEST_LOCATIONS.put(Submaps.BLACK_CASTLE_DRAWBRIDGE, ChestData.black_castle_drawbridge_chests);
    CHEST_LOCATIONS.put(Submaps.BLACK_CASTLE_ELEVATORS, ChestData.black_castle_elevator_chests);
    CHEST_LOCATIONS.put(Submaps.BLACK_CASTLE_WORKERS, ChestData.black_castle_workers_chests);
    CHEST_LOCATIONS.put(Submaps.BLACK_CASTLE_GARBAGE_FLOOR, ChestData.black_castle_garbage_floor_chests);
    CHEST_LOCATIONS.put(Submaps.BLACK_CASTLE_GARBAGE_LEVER, ChestData.black_castle_garbage_lever_chests);
    CHEST_LOCATIONS.put(Submaps.BLACK_CASTLE_MAGI_ROOM, ChestData.black_castle_magi_chests);
    CHEST_LOCATIONS.put(Submaps.BLACK_CASTLE_KONGOL_STAIRS, ChestData.black_castle_kongol_chests);

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
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_PUZZLE, ChestData.phantom_ship_puzzle_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_LOCKED_ROOM, ChestData.phantom_ship_locked_room_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_CRADLE, ChestData.phantom_ship_cradle_chests);
    CHEST_LOCATIONS.put(Submaps.LIDIERA_OUTSIDE, ChestData.lidiera_outside_chests);
    CHEST_LOCATIONS.put(Submaps.LIDIERA_CAVE, ChestData.lidiera_cave_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_BRIDGE, ChestData.undersea_cave_bridge_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_SECOND_ROOM, ChestData.undersea_cave_middle_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_WEST_ROOM, ChestData.undersea_cave_left_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_SAVE_ROOM, ChestData.undersea_cave_save_room_chests);
    CHEST_LOCATIONS.put(Submaps.FLETZ_TRAINING_ROOM, ChestData.fletz_training_chests);

    CHEST_LOCATIONS.put(Submaps.EVERGREEN_FOREST_RAT_TREE, ChestData.evergreen_forest_tree_chests);
    CHEST_LOCATIONS.put(Submaps.EVERGREEN_FOREST_WEST_PATH, ChestData.evergreen_forest_west_chests);
    CHEST_LOCATIONS.put(Submaps.EVERGREEN_FOREST_KAMUI_HILL, ChestData.evergreen_forest_kamuy_hill_chests);
    CHEST_LOCATIONS.put(Submaps.EVERGREEN_FOREST_MOUNTAIN_GUARD, ChestData.evergreen_forest_mountain_chests);
    CHEST_LOCATIONS.put(Submaps.CRYSTAL_PALACE_ENTRANCE, ChestData.crystal_palace_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.CRYSTAL_PALACE_DINING, ChestData.crystal_palace_interior_chests);
    CHEST_LOCATIONS.put(Submaps.FORBIDDEN_LAND_STEAM_VENTS, ChestData.forbidden_land_steam_vent_chests);
    CHEST_LOCATIONS.put(Submaps.FORBIDDEN_LAND_TELEPORTERS_2, ChestData.forbidden_land_teleporter_chests);
    CHEST_LOCATIONS.put(Submaps.FORBIDDEN_LAND_PLATFORM_ROOM, ChestData.forbidden_land_platform_chests);
    CHEST_LOCATIONS.put(Submaps.MOUNTAIN_OF_MORTAL_DRAGON_BONE_PATH, ChestData.mountain_of_mortal_dragon_base_chests);
    CHEST_LOCATIONS.put(Submaps.MOUNTAIN_OF_MORTAL_DRAGON_LEDGE, ChestData.mountain_of_mortal_dragon_ledge_chests);
    CHEST_LOCATIONS.put(Submaps.MOUNTAIN_OF_MORTAL_DRAGON_FORK_PATH, ChestData.mountain_of_mortal_dragon_path_chests);
    CHEST_LOCATIONS.put(Submaps.MOUNTAIN_OF_MORTAL_DRAGON_SAVE_ROOM, ChestData.mountain_of_mortal_dragon_save_chests);
    CHEST_LOCATIONS.put(Submaps.MOUNTAIN_OF_MORTAL_DRAGON_PRE_BOSS, ChestData.mountain_of_mortal_dragon_pre_boss_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_ENTRANCE, ChestData.kashua_glacier_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_SIGN_ROOM, ChestData.kashua_glacier_sign_room_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_MERCHANT, ChestData.kashua_glacier_merchant_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_ICICLE_ROOM, ChestData.kashua_glacier_icicle_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_BOSS_ROOM, ChestData.kashua_glacier_boss_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_TOWER, ChestData.kashua_glacier_tower_chests);
    CHEST_LOCATIONS.put(Submaps.FLANVEL_TOWER_ENTRANCE, ChestData.flanvel_tower_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.FLANVEL_TOWER_INTERIOR, ChestData.flanvel_tower_interior_chests);
    CHEST_LOCATIONS.put(Submaps.FLANVEL_TOWER_APPARITION, ChestData.flanvel_tower_apparition_chests);
    CHEST_LOCATIONS.put(Submaps.FLANVEL_TOWER_SAVE_ROOM_2, ChestData.flanvel_tower_save_2_chests);
    CHEST_LOCATIONS.put(Submaps.FLANVEL_TOWER_FAUST, ChestData.flanvel_tower_faust_chests);
    CHEST_LOCATIONS.put(Submaps.SNOWFIELD_ARCHES, ChestData.snowfield_arches_chests);
    CHEST_LOCATIONS.put(Submaps.SNOWFIELD_CLIFF_SLIDE, ChestData.snowfield_cliff_chests);
    CHEST_LOCATIONS.put(Submaps.FORT_MAGRAD_ENTRANCE, ChestData.fort_magrad_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.FORT_MAGRAD_SAVE_ROOM, ChestData.fort_magrad_save_chests);
    CHEST_LOCATIONS.put(Submaps.FORT_MAGRAD_BOSS, ChestData.fort_magrad_boss_chests);
    CHEST_LOCATIONS.put(Submaps.VELLWEB_MERCHANTS, ChestData.vellweb_stair_bottom_chests);
    CHEST_LOCATIONS.put(Submaps.VELLWEB_STAIR_CHEST_PATHS, ChestData.vellweb_stairs_chests);

    CHEST_LOCATIONS.put(Submaps.DEATH_FRONTIER_MAZE_1_CAVE, ChestData.death_frontier_maze1_cave_chests);
    CHEST_LOCATIONS.put(Submaps.DEATH_FRONTIER_MAZE_1_MIDDLE_CHEST, ChestData.death_frontier_maze1_middle_chests);
    CHEST_LOCATIONS.put(Submaps.DEATH_FRONTIER_MAZE_1_BOTTOM_LEFT_CHEST, ChestData.death_frontier_maze1_corner_chests);
    CHEST_LOCATIONS.put(Submaps.DEATH_FRONTIER_MAZE_2_BOTTOM_RIGHT_CHEST, ChestData.death_frontier_maze2_south_east_chests);
    CHEST_LOCATIONS.put(Submaps.DEATH_FRONTIER_MAZE_2_LEFT_CHEST, ChestData.death_frontier_maze2_left_chests);
    CHEST_LOCATIONS.put(Submaps.DEATH_FRONTIER_MAZE_2_TOP_RIGHT_CHEST, ChestData.death_frontier_maze2_north_east_chests);
    CHEST_LOCATIONS.put(Submaps.DEATH_FRONTIER_MAZE_2_CAVE_FRONT, ChestData.death_frontier_maze2_cave_front_chests);
    CHEST_LOCATIONS.put(Submaps.DEATH_FRONTIER_MAZE_2_CAVE_BACK, ChestData.death_frontier_maze2_cave_back_chests);
    CHEST_LOCATIONS.put(Submaps.ULARA_PORTAL, ChestData.ulara_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.ULARA_CHARLE_HOME, ChestData.ulara_charle_chests);
    CHEST_LOCATIONS.put(Submaps.ROUGE_BACK, ChestData.rouge_land_chests);
    CHEST_LOCATIONS.put(Submaps.ROUGE_FRONT_CHEST, ChestData.rouge_inside_chests);
    CHEST_LOCATIONS.put(Submaps.AGLIS_TELEPORTER_ROOM_1, ChestData.aglis_teleporter_1_chests);
    CHEST_LOCATIONS.put(Submaps.AGLIS_TELEPORTER_ROOM_2, ChestData.aglis_teleporter_2_chests);
    CHEST_LOCATIONS.put(Submaps.AGLIS_TELEPORTER_ROOM_3, ChestData.aglis_teleporter_3_chests);
    CHEST_LOCATIONS.put(Submaps.AGLIS_TELEPORTER_ROOM_4, ChestData.aglis_teleporter_4_chests);
    CHEST_LOCATIONS.put(Submaps.AGLIS_RESEARCH_ROOM, ChestData.aglis_research_room_chests);
    CHEST_LOCATIONS.put(Submaps.AGLIS_AFTER_BOMB, ChestData.aglis_after_bomb_room_chests);
    CHEST_LOCATIONS.put(Submaps.ZENEBATOS_FACTORY_TELEPORTERS, ChestData.zenebatos_factory_teleporters_chests);
    CHEST_LOCATIONS.put(Submaps.ZENEBATOS_LEGISLATION_TELEPORTERS, ChestData.zenebatos_legislation_teleporters_chests);
    CHEST_LOCATIONS.put(Submaps.ZENEBATOS_LAUNCHER_TELEPORTERS, ChestData.zenebatos_launcher_teleporters_chests);
    CHEST_LOCATIONS.put(Submaps.ZENEBATOS_JAIL, ChestData.zenebatos_jail_chests);
    CHEST_LOCATIONS.put(Submaps.MAYFIL_AREA_3, ChestData.mayfil_area_3_chests);
    CHEST_LOCATIONS.put(Submaps.MAYFIL_AREA_5, ChestData.mayfil_area_5_chests);
    CHEST_LOCATIONS.put(Submaps.MAYFIL_AREA_7, ChestData.mayfil_area_7_chests);
    CHEST_LOCATIONS.put(Submaps.MAYFIL_DIVINE_DRAGON_ROOM, ChestData.mayfil_divine_dragon_chests);
    CHEST_LOCATIONS.put(Submaps.MAYFIL_UNDER_LIGHT_BRIDGE, ChestData.mayfil_under_light_bridge_chests);
    CHEST_LOCATIONS.put(Submaps.MAYFIL_RECOVERY_ROOM, ChestData.mayfil_healing_room_chests);
    CHEST_LOCATIONS.put(Submaps.MAYFIL_LAVITZ_ROOM, ChestData.mayfil_lavitz_chests);
    CHEST_LOCATIONS.put(Submaps.MAYFIL_BEFORE_SIGNET, ChestData.mayfil_before_signet_chests);
    CHEST_LOCATIONS.put(Submaps.DIVINE_TREE_FIRST_ROOM, ChestData.divine_tree_first_room_chests);
    CHEST_LOCATIONS.put(Submaps.DIVINE_TREE_HEALING_ROOM, ChestData.divine_tree_healing_water_chests);
    CHEST_LOCATIONS.put(Submaps.MOON_FOREST, ChestData.moon_forest_chests);
    CHEST_LOCATIONS.put(Submaps.MOON_SNOW, ChestData.moon_snow_chests);
    CHEST_LOCATIONS.put(Submaps.MOON_MININTOS_HOMES, ChestData.moon_minintos_chests);
    CHEST_LOCATIONS.put(Submaps.MOON_MININTOS_PATH, ChestData.moon_after_minintos_chests);
    CHEST_LOCATIONS.put(Submaps.MOON_SOUTH_PATH, ChestData.moon_south_path_chests);
    CHEST_LOCATIONS.put(Submaps.MOON_GIGANTOS_HOME, ChestData.moon_giganto_chests);
    CHEST_LOCATIONS.put(Submaps.MOON_MICHAELS_REALM_2, ChestData.moon_michaels_realm_chests);
    CHEST_LOCATIONS.put(Submaps.MOON_TV_ROOM_2, ChestData.moon_tv_core_chests);
    CHEST_LOCATIONS.put(Submaps.MOON_VIRAGE_SAVE_ROOM, ChestData.moon_virage_save_room_chests);
  }

  private Chests() {
  }

  public static Map<Integer, Map<Integer, Long>> getStaticMap() {
    return Collections.unmodifiableMap(CHEST_LOCATIONS);
  }

  public static Set<Long> getStaticFlatMap() {
    final LinkedHashSet<Long> locationMap = new LinkedHashSet<>();
    for(final Map.Entry<Integer, Map<Integer, Long>> areaInfo : CHEST_LOCATIONS.entrySet()) {
      locationMap.addAll(areaInfo.getValue().values());
    }

    return Collections.unmodifiableSet(locationMap);
  }

  public static Long getAPLocationId(final int submap, final int objectIndex) {
    try {
      return getStaticMap().get(submap).getOrDefault(objectIndex, -1L);
    } catch(final Exception e) {
      return -1L;
    }
  }
}
