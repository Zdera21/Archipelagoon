package archipelagoon.ap.events;

import archipelagoon.ap.mapping.LocationState;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.LocationInfoEvent;
import io.github.archipelagomw.parts.NetworkItem;
import legend.core.GameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static archipelagoon.Archipelagoon.LOCATION_STATE_REGISTRY;

public class LocationInfoListener {
  @ArchipelagoEventListener
  public void onLocationInfoEvent(final LocationInfoEvent event) {
    final List<LocationState> locationList = new ArrayList<>();
    final List<LocationState> existingStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());

    for(final NetworkItem item : event.locations) {
      boolean applied = false;

      if(!existingStates.isEmpty()) {
        final List<LocationState> result = existingStates.stream()
          .filter(a -> Objects.equals(a.getLocationID(), item.locationID))
          .toList();
        applied = !result.isEmpty() && result.getFirst().isApplied();
      }

      final LocationState locationState = new LocationState(item, applied);
      locationList.add(locationState);
    }

    GameEngine.CONFIG.setConfig(LOCATION_STATE_REGISTRY.get(), locationList);
  }
}
