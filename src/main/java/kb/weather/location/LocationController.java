package kb.weather.location;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationMapper locationMapper;
    private final LocationService locationService;

    @PostMapping("/location")
    ResponseEntity<NewLocationResponse> postLocation(@RequestBody CreateLocationRequest request) {
        Location location = locationService.createLocation(
                request.getCity(),
                request.getRegion(),
                request.getCountry(),
                request.getLatitude(),
                request.getLongitude());

        NewLocationResponse responseBody = locationMapper.mapLocationToNewLocationResponse(locationService, location);

        return ResponseEntity.status(201).body(responseBody);
    }
}
