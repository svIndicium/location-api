package hu.indicium.dev.location.infrastructure.web.controllers;

import hu.indicium.dev.location.application.commands.CreateLocationCommand;
import hu.indicium.dev.location.application.query.LocationQueryService;
import hu.indicium.dev.location.application.service.LocationService;
import hu.indicium.dev.location.domain.model.location.BaseLocation;
import hu.indicium.dev.location.domain.model.location.Location;
import hu.indicium.dev.location.domain.model.location.LocationId;
import hu.indicium.dev.location.domain.model.location.PartnerLocation;
import hu.indicium.dev.location.domain.model.partner.PartnerId;
import hu.indicium.dev.location.infrastructure.web.dto.BaseLocationDto;
import hu.indicium.dev.location.infrastructure.web.dto.LocationDto;
import hu.indicium.dev.location.infrastructure.web.dto.PartnerLocationDto;
import hu.indicium.dev.location.util.Response;
import hu.indicium.dev.location.util.ResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import static hu.indicium.dev.location.util.BaseUrl.API_V1;

@RestController
@AllArgsConstructor
@RequestMapping(API_V1)
public class LocationController {

    private final LocationService locationService;

    private final LocationQueryService locationQueryService;

    @GetMapping("/locations")
    @ResponseStatus(HttpStatus.OK)
    public Response<Collection<BaseLocationDto>> getAllLocations() {
        Collection<BaseLocation> locations = locationQueryService.getAllLocations();
        Collection<BaseLocationDto> locationDtos = locations.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
        return ResponseBuilder.ok()
                .data(locationDtos)
                .build();
    }

    @GetMapping("/locations/{locationUuid}")
    @ResponseStatus(HttpStatus.OK)
    public Response<BaseLocationDto> getLocationById(@PathVariable UUID locationUuid) {
        LocationId locationId = LocationId.fromId(locationUuid);
        BaseLocation baseLocation = locationQueryService.getLocationByLocationId(locationId);
        BaseLocationDto baseLocationDto = this.toDto(baseLocation);
        return ResponseBuilder.ok()
                .data(baseLocationDto)
                .build();
    }

    @PostMapping("/locations")
    @ResponseStatus(HttpStatus.OK)
    public Response<LocationDto> getLocationById(@RequestBody CreateLocationCommand createLocationCommand) {
        LocationId locationId = locationService.createLocation(createLocationCommand);
        BaseLocation baseLocation = locationQueryService.getLocationByLocationId(locationId);
        BaseLocationDto baseLocationDto = this.toDto(baseLocation);
        return ResponseBuilder.ok()
                .data(baseLocationDto)
                .build();
    }

    @GetMapping("/partners/{partnerUuid}/locations")
    @ResponseStatus(HttpStatus.OK)
    public Response<PartnerLocationDto> getLocationForPartnerId(@PathVariable UUID partnerUuid) {
        PartnerId partnerId = PartnerId.fromUuid(partnerUuid);
        Collection<PartnerLocation> locations = locationQueryService.getLocationByPartnerId(partnerId);
        Collection<PartnerLocationDto> locationDtos = locations.stream()
                .map(PartnerLocationDto::new)
                .collect(Collectors.toSet());
        return ResponseBuilder.ok()
                .data(locationDtos)
                .build();
    }

    private BaseLocationDto toDto(BaseLocation baseLocation) {
        if (baseLocation instanceof Location) {
            return new LocationDto((Location) baseLocation);
        } else if (baseLocation instanceof PartnerLocation) {
            return new PartnerLocationDto((PartnerLocation) baseLocation);
        } else {
            return new BaseLocationDto(baseLocation);
        }
    }
}
