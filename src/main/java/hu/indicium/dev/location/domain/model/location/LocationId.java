package hu.indicium.dev.location.domain.model.location;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@NoArgsConstructor
@Getter
public class LocationId implements Serializable {
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private LocationId(UUID uuid) {
        this.id = uuid;
    }

    public static LocationId fromId(UUID uuid) {
        return new LocationId(uuid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationId that = (LocationId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
