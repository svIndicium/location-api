package hu.indicium.dev.location.application.query;

import hu.indicium.dev.location.domain.model.location.BaseLocation;
import hu.indicium.dev.location.domain.model.location.LocationId;
import hu.indicium.dev.location.domain.model.location.PartnerLocation;
import hu.indicium.dev.location.domain.model.partner.PartnerId;

import java.util.Collection;

public interface LocationQueryService  {
    Collection<BaseLocation> getAllLocations();

    Collection<PartnerLocation> getLocationByPartnerId(PartnerId partnerId);

    BaseLocation getLocationByLocationId(LocationId locationId);
}
