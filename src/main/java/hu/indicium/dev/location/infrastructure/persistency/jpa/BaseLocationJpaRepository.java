package hu.indicium.dev.location.infrastructure.persistency.jpa;

import hu.indicium.dev.location.domain.model.location.BaseLocation;
import hu.indicium.dev.location.domain.model.location.PartnerLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface BaseLocationJpaRepository extends JpaRepository<BaseLocation, UUID> {
}
