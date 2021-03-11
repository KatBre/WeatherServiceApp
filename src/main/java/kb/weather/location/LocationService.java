package kb.weather.location;

import kb.weather.exceptions.EmptyInputException;
import kb.weather.exceptions.ValueOutOfRangeException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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
        if (StringUtils.isBlank(city)) {
            throw new EmptyInputException("Empty city not accepted");
        }
        if (StringUtils.isBlank(region)) {
            region = null;
        }
        if (StringUtils.isBlank(country)) {
            throw new EmptyInputException("Empty country not accepted");
        }
        if (latitude < SOUTH_LIMIT || latitude > NORTH_LIMIT) {
            throw new ValueOutOfRangeException("Latitude out of range. Accepted value within the range -90 to 90.");
        }
        if (longitude < WEST_LIMIT || longitude > EAST_LIMIT) {
            throw new ValueOutOfRangeException("Longitude out of range. Accepted value within the range -180 to 180.");
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
