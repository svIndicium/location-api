package hu.indicium.dev.location.infrastructure.persistency.jpa;

import hu.indicium.dev.location.domain.model.location.PartnerLocation;
import hu.indicium.dev.location.domain.model.partner.PartnerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface PartnerLocationJpaRepository extends JpaRepository<PartnerLocation, UUID> {
    Collection<PartnerLocation> findAllByPartnerId(PartnerId partnerId);
}
