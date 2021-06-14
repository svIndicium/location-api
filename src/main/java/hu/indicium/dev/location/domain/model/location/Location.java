package hu.indicium.dev.location.domain.model.location;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
public class Location extends BaseLocation {

    private String name;

    private String description;

    public Location(LocationId locationId, LocationDetails locationDetails, String name, String description) {
        super(locationId, locationDetails);
        this.name = name;
        this.description = description;
    }
}
