package archipelagoon.randomizer;

import archipelagoon.data.enums.StoryFlags;
import legend.core.GameEngine;
import legend.game.modding.events.scripting.ReadGlobalFlagsEvent;
import legend.game.modding.events.submap.SubmapWarpEvent;
import legend.game.scripting.ScriptFlagArrayEnum;
import legend.lodmod.LodGoods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import archipelagoon.data.enums.Submaps;

import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public final class StoryFlagManager {
  private static final StoryFlagManager INSTANCE = new StoryFlagManager();
  private static int current_submap = -1;
  private static final Logger LOGGER = LogManager.getFormatterLogger(StoryFlagManager.class);

  private StoryFlagManager(){
  }

  public static StoryFlagManager getInstance(){
    return INSTANCE;
  }

  public static int getCurrentSubmap(){
    if (current_submap == -1){
      LOGGER.warn("StoryFlagManager.getCurrentSubmap() returned a -1. Submap variable may not have been initialized yet.");
    }
    return current_submap;
  }

  public static void submapWarpListener(final SubmapWarpEvent event){
    current_submap = event.submapCut;
  }

  public static void readScriptFlags(final ReadGlobalFlagsEvent event) {
    if(event.flagArray == ScriptFlagArrayEnum.FLAGS2) {
      switch(event.getFlagIndex()) {
        case StoryFlags.FOREST_MERCHANT_1, StoryFlags.FOREST_MERCHANT_2:
          if (current_submap == Submaps.FOREST_MERCHANT){
            event.flagValue = false;
          }
          break;
        case StoryFlags.NEST_OF_DRAGON_PLANT:
          if (current_submap == Submaps.NEST_OF_DRAGON_PLANT) {
            event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.LIFE_WATER.getId()));
          }
          break;
        case StoryFlags.NEST_OF_DRAGON_LIFE_WATER:
          if (current_submap == Submaps.NEST_OF_DRAGON_LIFE_WATER) {
            event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.WATER_BOTTLE.getId()));
          }
          break;
        case StoryFlags.HELLENA_SHANA_DOOR:
          if (current_submap == Submaps.HELLENA_ELEVATOR) {
            event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.PRISON_KEY.getId()));
          }
          break;
        case StoryFlags.FURNI_BOAT:
          //TODO: GET SUBMAP VALUE FOR BOAT LICENSE
          event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.BOAT_LICENSE.getId()));
          break;
      }
    } else if(event.flagArray == ScriptFlagArrayEnum.FLAGS1) {
      switch(event.getFlagIndex()) {
        case StoryFlags.PRAIRIE_CLIFF_TREE:
          if (current_submap == Submaps.PRAIRIE_CLIFF_TREE){
            event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.AXE_FROM_THE_SHACK.getId()));
          }
          break;
      }
    }
  }

}
