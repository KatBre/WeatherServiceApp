package kb.weather_service_app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationController {

    @PostMapping("/location")
    ResponseEntity<NewLocationResponse> postLocation(@RequestBody CreateLocationRequest request) {
        String city = request.getCity();
        String region = request.getRegion();
        String country = request.getCountry();
        Double latitude = request.getLatitude();
        Double longitude = request.getLongitude();
        NewLocationResponse responseBody = new NewLocationResponse(city, region, country, latitude, longitude);

        return ResponseEntity.status(201).body(responseBody);
    }
}
