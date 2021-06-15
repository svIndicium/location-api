package hu.indicium.dev.location.infrastructure.web.dto;

import hu.indicium.dev.location.domain.model.location.BaseLocation;
import lombok.Getter;

import java.util.UUID;

@Getter
public class BaseLocationDto {
    private final UUID locationId;

    private final String street;

    private final String houseNumber;

    private final String postalCode;

    private final String city;

    private final String country;

    public BaseLocationDto(BaseLocation baseLocation) {
        this.locationId = baseLocation.getLocationId().getId();
        this.street = baseLocation.getLocationDetails().getStreet();
        this.houseNumber = baseLocation.getLocationDetails().getHouseNumber();
        this.postalCode = baseLocation.getLocationDetails().getPostalCode();
        this.city = baseLocation.getLocationDetails().getCity();
        this.country = baseLocation.getLocationDetails().getCountry();
    }
}
