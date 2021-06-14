package hu.indicium.dev.location.infrastructure.web.controllers;

import hu.indicium.dev.location.application.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static hu.indicium.dev.location.util.BaseUrl.API_V1;

@RestController
@AllArgsConstructor
@RequestMapping(API_V1)
public class LocationController {

    private final LocationService locationService;


}
