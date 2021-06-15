package hu.indicium.dev.location.domain.model.location;

import hu.indicium.dev.location.domain.AssertionConcern;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LocationDetails extends AssertionConcern implements Serializable {
    @Column(name = "street")
    private String street;

    @Column(name = "houseNumber")
    private String houseNumber;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    protected LocationDetails(String street, String houseNumber, String postalCode, String city, String country) {
        this.setStreet(street);
        this.setHouseNumber(houseNumber);
        this.setPostalCode(postalCode);
        this.setCity(city);
        this.setCountry(country);
    }

    private void setStreet(String street) {
        this.assertArgumentNotEmpty(street, "Street may not be empty.");

        this.street = street;
    }

    private void setHouseNumber(String houseNumber) {
        this.assertArgumentNotEmpty(houseNumber, "Housenumber may not be empty.");

        this.houseNumber = houseNumber;
    }

    private void setPostalCode(String postalCode) {
        this.assertArgumentIsValidByRegex(postalCode, "^[1-9][0-9]{3}[\\s]?[A-Za-z]{2}$", "Postal code must be valid.");
        postalCode = postalCode.replaceAll("\\s+", "");

        this.postalCode = postalCode;
    }

    private void setCity(String city) {
        this.assertArgumentNotEmpty(city, "City may not be empty.");

        this.city = city;
    }

    private void setCountry(String country) {
        this.assertArgumentNotEmpty(country, "Country may not be empty.");

        this.country = country;
    }
}
