package kb.weather_service_app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    Location createLocation(String city, String region, String country, Double latitude, Double longitude) {
        // todo add validation of passed data
        Location location = new Location();
        location.setCity(city);
        location.setRegion(region); // todo if user pass there an empty value (eg. "  ") you can set null
        location.setCountry(country);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        return locationRepository.save(location);
    }
}
