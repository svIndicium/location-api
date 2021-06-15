package hu.indicium.dev.location.infrastructure.web.dto;

import hu.indicium.dev.location.domain.model.location.BaseLocation;
import hu.indicium.dev.location.domain.model.location.Location;
import lombok.Getter;

@Getter
public class LocationDto extends BaseLocationDto {

    private final String name;

    private final String description;

    public LocationDto(Location location) {
        super(location);
        this.name = location.getName();
        this.description = location.getDescription();
    }
}
