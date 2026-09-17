package archipelagoon.randomizer;

import legend.core.GameEngine;
import legend.game.modding.events.scripting.ReadGlobalFlagsEvent;
import legend.game.modding.events.submap.SubmapWarpEvent;
import legend.game.scripting.ScriptFlagArrayEnum;
import legend.lodmod.LodGoods;

import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public final class StoryFlagManager {
  private static final StoryFlagManager INSTANCE = new StoryFlagManager();
  private static int current_submap = -1;

  private StoryFlagManager(){
  }

  public static StoryFlagManager getInstance(){
    return INSTANCE;
  }

  public static int getCurrentSubmap(){
    if (current_submap == -1){
      //TODO: replace this with real logging mechanism
      System.out.println("WARNING: StoryFlagManager.getCurrentSubmap() returned a -1. Submap variable may not have been initialized yet.");
    }
    return current_submap;
  }

  public static void submapListener(final SubmapWarpEvent event){
    current_submap = event.submapCut;
    System.out.println("Current Submap is: " + current_submap);
  }

  public static void readScriptFlags(final ReadGlobalFlagsEvent event) {
    if(event.flagArray == ScriptFlagArrayEnum.FLAGS2) {
      switch(event.getFlagIndex()) {
        case 11, 16:
          //Forest Merchant
          if (current_submap == 624){
            event.flagValue = false;
          }
          break;
        case 59:
          //Nest of Dragon plant
          if (current_submap == 132) {
            event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.LIFE_WATER.getId()));
          }
          break;
        case 58:
          //Nest of Dragon life water puddle
          if (current_submap == 133) {
            event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.WATER_BOTTLE.getId()));
          }
          break;
        case 9:
          //Hellena Shana's prison tower
          if (current_submap == 20) {
            event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.PRISON_KEY.getId()));
          }
          break;
        case 203:
          event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.BOAT_LICENSE.getId()));
          break;
      }
    } else if(event.flagArray == ScriptFlagArrayEnum.FLAGS1) {
      switch(event.getFlagIndex()) {
        case 1:
          //Prairie Tree with axe
          if (current_submap == 42){
            event.flagValue = gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(LodGoods.AXE_FROM_THE_SHACK.getId()));
          }
          break;
      }
    }
  }

}
