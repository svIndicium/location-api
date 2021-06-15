package hu.indicium.dev.location.application.service;

import hu.indicium.dev.location.application.commands.CreateLocationCommand;
import hu.indicium.dev.location.domain.model.location.*;
import hu.indicium.dev.location.domain.model.partner.PartnerId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public LocationId createLocation(CreateLocationCommand createLocationCommand) {
        LocationId locationId = locationRepository.nextIdentity();

        LocationDetails locationDetails = buildLocationDetails(createLocationCommand);

        Location location = new Location(locationId, locationDetails, createLocationCommand.getName(), createLocationCommand.getDescription());

        locationRepository.save(location);

        return locationId;
    }

    @Override
    public LocationId createLocationForPartner(PartnerId partnerId, CreateLocationCommand createLocationCommand) {
        LocationId locationId = locationRepository.nextIdentity();

        LocationDetails locationDetails = buildLocationDetails(createLocationCommand);

        PartnerLocation partnerLocation = new PartnerLocation(locationId, partnerId, locationDetails);

        locationRepository.save(partnerLocation);

        return locationId;
    }

    private LocationDetails buildLocationDetails(CreateLocationCommand createLocationCommand) {
        return LocationDetails.builder()
                .street(createLocationCommand.getStreet())
                .houseNumber(createLocationCommand.getHouseNumber())
                .postalCode(createLocationCommand.getPostalCode())
                .city(createLocationCommand.getCity())
                .country(createLocationCommand.getCountry())
                .build();
    }
}
