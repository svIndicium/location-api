package hu.indicium.dev.location.domain.model.location;

import hu.indicium.dev.location.domain.AssertionConcern;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
public abstract class BaseLocation extends AssertionConcern {
    @EmbeddedId
    private LocationId locationId;

    @Embedded
    private LocationDetails locationDetails;

    public BaseLocation(LocationId locationId, LocationDetails locationDetails) {
        this.locationId = locationId;
        this.locationDetails = locationDetails;
    }
}
