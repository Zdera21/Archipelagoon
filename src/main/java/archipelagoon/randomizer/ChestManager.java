package archipelagoon.randomizer;

import archipelagoon.ap.mapping.locations.Chests;

import static legend.game.Scus94491BpeSegment_8005.collidedPrimitiveIndex_80052c38;
import static legend.game.Scus94491BpeSegment_8005.submapCut_80052c30;

public class ChestManager {
  private static final ChestManager INSTANCE = new ChestManager();

  private ChestManager() {
  }

  public static ChestManager getInstance() {
    return INSTANCE;
  }

  public Long getChestId() {
    return Chests.getAPLocationId(submapCut_80052c30, collidedPrimitiveIndex_80052c38);
  }
}
