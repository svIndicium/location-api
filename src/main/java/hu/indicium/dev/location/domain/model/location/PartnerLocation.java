package hu.indicium.dev.location.domain.model.location;

import hu.indicium.dev.location.domain.model.partner.PartnerId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
public class PartnerLocation extends BaseLocation {
    @Embedded
    private PartnerId partnerId;

    public PartnerLocation(LocationId locationId, PartnerId partnerId, LocationDetails locationDetails) {
        super(locationId, locationDetails);
        this.partnerId = partnerId;
    }
}
