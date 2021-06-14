package hu.indicium.dev.location.application.service;

import hu.indicium.dev.location.application.commands.CreateLocationCommand;
import hu.indicium.dev.location.domain.model.location.Location;
import hu.indicium.dev.location.domain.model.location.LocationId;

public interface LocationService {
    LocationId createLocation(CreateLocationCommand createLocationCommand);
}
