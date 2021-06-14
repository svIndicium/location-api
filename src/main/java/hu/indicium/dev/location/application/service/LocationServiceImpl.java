package hu.indicium.dev.location.application.service;

import hu.indicium.dev.location.application.commands.CreateLocationCommand;
import hu.indicium.dev.location.domain.model.location.Location;
import hu.indicium.dev.location.domain.model.location.LocationDetails;
import hu.indicium.dev.location.domain.model.location.LocationId;
import hu.indicium.dev.location.domain.model.location.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public LocationId createLocation(CreateLocationCommand createLocationCommand) {
        LocationId locationId = locationRepository.nextIdentity();

        LocationDetails locationDetails = LocationDetails.builder()
                .street(createLocationCommand.getStreet())
                .houseNumber(createLocationCommand.getHouseNumber())
                .postalCode(createLocationCommand.getPostalCode())
                .city(createLocationCommand.getCity())
                .country(createLocationCommand.getCountry())
                .build();

        Location location = new Location(locationId, locationDetails, createLocationCommand.getName(), createLocationCommand.getDescription());

        locationRepository.save(location);

        return locationId;
    }
}
