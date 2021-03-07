package kb.weather.location;

import kb.weather.exceptions.EmptyInputException;
import kb.weather.exceptions.ValueOutOfRangeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationService {
    private final Double NORTH_LIMIT = 90.0;
    private final Double SOUTH_LIMIT = -90.0;
    private final Double EAST_LIMIT = 180.0;
    private final Double WEST_LIMIT = -180.0;

    private final LocationRepository locationRepository;

    Location createLocation(String city, String region, String country, Double latitude, Double longitude) {
        if (city.isEmpty()) {
            throw new EmptyInputException("Empty value not accepted");
        }
        if (region.equals(" ")) {
            region = null;
        }
        if (country.isEmpty()) {
            throw new EmptyInputException("Empty value not accepted");
        }
        if (latitude < SOUTH_LIMIT || latitude > NORTH_LIMIT) {
            throw new ValueOutOfRangeException("Value out of range");
        }
        if (longitude < WEST_LIMIT || longitude > EAST_LIMIT) {
            throw new ValueOutOfRangeException("Value out of range");
        }

        Location location = new Location();
        location.setCity(city);
        location.setRegion(region);
        location.setCountry(country);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        return locationRepository.save(location);
    }
}
