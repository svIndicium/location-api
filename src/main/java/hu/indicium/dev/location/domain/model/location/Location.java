package hu.indicium.dev.location.domain.model.location;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
public class Location extends BaseLocation {

    private String name;

    private String description;
}
