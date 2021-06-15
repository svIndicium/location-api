package hu.indicium.dev.location.infrastructure.web.dto;

import hu.indicium.dev.location.domain.model.location.PartnerLocation;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PartnerLocationDto extends BaseLocationDto {
    private final UUID partnerId;

    public PartnerLocationDto(PartnerLocation partnerLocation) {
        super(partnerLocation);
        this.partnerId = partnerLocation.getPartnerId().getId();
    }
}
