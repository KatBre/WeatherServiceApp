package kb.weather.location;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final LocationMapper locationMapper;

    @PostMapping("/location")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<NewLocationResponse> postLocation(@RequestBody @Valid CreateLocationRequest request) {
        Location location = locationService.createLocation(
                request.getCity(),
                request.getRegion(),
                request.getCountry(),
                request.getLatitude(),
                request.getLongitude());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(locationMapper.mapLocationToNewLocationResponse(location));
    }
}
