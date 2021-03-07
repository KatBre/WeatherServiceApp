package kb.weather.location;

public class LocationMapper {
    NewLocationResponse mapLocationToNewLocationResponse(LocationService locationService, Location location){
        return NewLocationResponse.builder()
                .uuid(location.getUuid())
                .city(location.getUuid())
                .region(location.getRegion())
                .country(location.getCountry())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();

    }

}
