package archipelagoon.ap.events;

import archipelagoon.ap.APClient;
import archipelagoon.ap.mapping.LocationState;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.LocationInfoEvent;
import io.github.archipelagomw.parts.NetworkItem;
import legend.core.GameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static archipelagoon.Archipelagoon.LOCATION_STATE_REGISTRY;

public class LocationInfoListener {
  @ArchipelagoEventListener
  public void onLocationInfoEvent(final LocationInfoEvent event) {
    final List<LocationState> locationList = new ArrayList<>();
    final Set<Long> checkedLocations = APClient.client.getLocationManager().getCheckedLocations();

    for(final NetworkItem item : event.locations) {
      final boolean applied = checkedLocations.contains(item.locationID);
      final LocationState locationState = new LocationState(item, applied);
      locationList.add(locationState);
    }

    GameEngine.CONFIG.setConfig(LOCATION_STATE_REGISTRY.get(), locationList);
  }
}
