package hu.indicium.dev.location.domain.model.partner;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@NoArgsConstructor
public class PartnerId implements Serializable {
    @Column(name = "partner_id")
    private UUID id;

    private PartnerId(UUID id) {
        this.id = id;
    }

    public static PartnerId fromUuid(UUID id) {
        return new PartnerId(id);
    }
}
