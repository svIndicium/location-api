package hu.indicium.dev.location.infrastructure.persistency;

import hu.indicium.dev.location.domain.model.location.BaseLocation;
import hu.indicium.dev.location.domain.model.location.LocationId;
import hu.indicium.dev.location.domain.model.location.LocationRepository;
import hu.indicium.dev.location.domain.model.location.PartnerLocation;
import hu.indicium.dev.location.domain.model.partner.PartnerId;
import hu.indicium.dev.location.infrastructure.persistency.jpa.BaseLocationJpaRepository;
import hu.indicium.dev.location.infrastructure.persistency.jpa.PartnerLocationJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Repository
@AllArgsConstructor
public class BaseLocationRepositoryImpl implements LocationRepository {

    private final BaseLocationJpaRepository baseLocationJpaRepository;

    private final PartnerLocationJpaRepository partnerLocationJpaRepository;

    @Override
    public BaseLocation findLocationById(LocationId locationId) {
        return baseLocationJpaRepository.findById(locationId.getId())
                .orElseThrow(() -> new EntityNotFoundException("Location not found with id " + locationId.getId().toString()));
    }

    @Override
    public Collection<BaseLocation> getAllLocations() {
        return baseLocationJpaRepository.findAll();
    }

    @Override
    public Collection<PartnerLocation> getAllLocationsByPartnerId(PartnerId partnerId) {
        return partnerLocationJpaRepository.findAllByPartnerId(partnerId);
    }

    @Override
    public <T extends BaseLocation> T save(T location) {
        return baseLocationJpaRepository.save(location);
    }
}
