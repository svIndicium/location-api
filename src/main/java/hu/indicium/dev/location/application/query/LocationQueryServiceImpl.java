package hu.indicium.dev.location.application.query;

import hu.indicium.dev.location.domain.model.location.BaseLocation;
import hu.indicium.dev.location.domain.model.location.LocationId;
import hu.indicium.dev.location.domain.model.location.LocationRepository;
import hu.indicium.dev.location.domain.model.location.PartnerLocation;
import hu.indicium.dev.location.domain.model.partner.PartnerId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class LocationQueryServiceImpl implements LocationQueryService {

    private final LocationRepository locationRepository;

    @Override
    public Collection<BaseLocation> getAllLocations() {
        return locationRepository.getAllLocations();
    }

    @Override
    public Collection<PartnerLocation> getLocationByPartnerId(PartnerId partnerId) {
        return locationRepository.getAllLocationsByPartnerId(partnerId);
    }

    @Override
    public BaseLocation getLocationByLocationId(LocationId locationId) {
        return locationRepository.findLocationById(locationId);
    }
}
