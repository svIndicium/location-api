package hu.indicium.dev.location.application.commands;

import lombok.Data;

@Data
public class CreateLocationCommand {
    private String name;

    private String description;

    private String street;

    private String houseNumber;

    private String postalCode;

    private String city;

    private String country;
}
