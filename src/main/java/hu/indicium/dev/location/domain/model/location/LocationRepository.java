package hu.indicium.dev.location.domain.model.location;

import hu.indicium.dev.location.domain.model.partner.PartnerId;

import java.util.Collection;

public interface LocationRepository {
    BaseLocation findLocationById(LocationId locationId);

    Collection<BaseLocation> getAllLocations();

    Collection<PartnerLocation> getAllLocationsByPartnerId(PartnerId partnerId);

    <T extends BaseLocation> T save(T location);
}
