package kb.weather.location;

import kb.weather.exceptions.EmptyInputException;
import kb.weather.exceptions.ValueOutOfRangeException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LocationServiceTests {
    @Mock
    LocationRepository locationRepository;
    @InjectMocks
    LocationService locationService;

    @Test
    void createLocation_createsNewLocation() {
        //given
        Location testLocation = Location.builder()
                .city("Gdynia")
                .region("pomeranian")
                .country("Poland")
                .latitude(54.5)
                .longitude(18.5)
                .build();
        when(locationRepository.save(any())).thenReturn(testLocation);

        //when
        Location location = locationService.createLocation("Gdynia", "pomeranian", "Poland", 54.5, 18.5);

        //then
        assertThat(location.getCity()).isEqualTo("Gdynia");
        assertThat(location.getRegion()).isEqualTo("pomeranian");
        assertThat(location.getCountry()).isEqualTo("Poland");
        assertThat(location.getLatitude()).isEqualTo(54.5);
        assertThat(location.getLongitude()).isEqualTo(18.5);
        verify(locationRepository).save(any());
    }

    @Test
    void createLocation_whenCityIsEmpty_throwsEmptyInputException() {
        //when
        Throwable exception = catchThrowable(() -> locationService.createLocation("", "pomeranian", "Poland", 54.5, 18.5));

        //then
        assertThat(exception).isInstanceOf(EmptyInputException.class);
        verify(locationRepository, times(0)).save(any());
    }

    @Test
    void createLocation_whenCityIsNull_throwsEmptyInputException() {
        //when
        Throwable exception = catchThrowable(() -> locationService.createLocation(null, "pomeranian", "Poland", 54.5, 18.5));

        //then
        assertThat(exception).isInstanceOf(EmptyInputException.class);
        verify(locationRepository, times(0)).save(any());
    }

    @Test
    void createLocation_whenCountryIsEmpty_throwsEmptyInputException() {
        //when
        Throwable exception = catchThrowable(() -> locationService.createLocation("Gdynia", "pomeranian", "", 54.5, 18.5));

        //then
        assertThat(exception).isInstanceOf(EmptyInputException.class);
        verify(locationRepository, times(0)).save(any());
    }

    @Test
    void createLocation_whenCountryIsNull_throwsEmptyInputException() {
        //when
        Throwable exception = catchThrowable(() -> locationService.createLocation("Gdynia", "pomeranian", null, 54.5, 18.5));

        //then
        assertThat(exception).isInstanceOf(EmptyInputException.class);
        verify(locationRepository, times(0)).save(any());
    }

    @Test
    void createLocation_whenLatitudeIsHigherThenLimit_throwsValueOutOfRangeException() {
        //when
        Throwable exception = catchThrowable(() -> locationService.createLocation("Gdynia", "pomeranian", "Poland", 100.5, 18.5));

        //then
        assertThat(exception).isInstanceOf(ValueOutOfRangeException.class);
        verify(locationRepository, times(0)).save(any());
    }

    @Test
    void createLocation_whenLatitudeIsLowerThenLimit_throwsValueOutOfRangeException() {
        //when
        Throwable exception = catchThrowable(() -> locationService.createLocation("Gdynia", "pomeranian", "Poland", -100.5, 18.5));

        //then
        assertThat(exception).isInstanceOf(ValueOutOfRangeException.class);
        verify(locationRepository, times(0)).save(any());
    }

    @Test
    void createLocation_whenLongitudeIsHigherThenLimit_throwsValueOutOfRangeException() {
        //when
        Throwable exception = catchThrowable(() -> locationService.createLocation("Gdynia", "pomeranian", "Poland", 54.5, 200.5));

        //then
        assertThat(exception).isInstanceOf(ValueOutOfRangeException.class);
        verify(locationRepository, times(0)).save(any());
    }

    @Test
    void createLocation_whenLongitudeIsLowerThenLimit_throwsValueOutOfRangeException() {
        //when
        Throwable exception = catchThrowable(() -> locationService.createLocation("Gdynia", "pomeranian", "Poland", 54.5, -200.5));

        //then
        assertThat(exception).isInstanceOf(ValueOutOfRangeException.class);
        verify(locationRepository, times(0)).save(any());
    }

    @Test
    void createLocation_whenRegionIsEmpty_createNewLocationWithEmptyRegion() {
        Location testLocation = Location.builder()
                .city("Gdynia")
                .region(" ")
                .country("Poland")
                .latitude(54.5)
                .longitude(18.5)
                .build();
        when(locationRepository.save(any())).thenReturn(testLocation);

        //when
        Location location = locationService.createLocation("Gdynia", " ", "Poland", 54.5, 18.5);

        //then
        assertThat(location.getCity()).isEqualTo("Gdynia");
        assertThat(location.getRegion()).isEqualTo(null);
        assertThat(location.getCountry()).isEqualTo("Poland");
        assertThat(location.getLatitude()).isEqualTo(54.5);
        assertThat(location.getLongitude()).isEqualTo(18.5);
        verify(locationRepository).save(any());
    }

    @Test
    void createLocation_whenRegionIsNull_createNewLocationWithNullRegion() {
        Location testLocation = Location.builder()
                .city("Gdynia")
                .region(null)
                .country("Poland")
                .latitude(54.5)
                .longitude(18.5)
                .build();
        when(locationRepository.save(any())).thenReturn(testLocation);

        //when
        Location location = locationService.createLocation("Gdynia", null, "Poland", 54.5, 18.5);

        //then
        assertThat(location.getCity()).isEqualTo("Gdynia");
        assertThat(location.getRegion()).isEqualTo(null);
        assertThat(location.getCountry()).isEqualTo("Poland");
        assertThat(location.getLatitude()).isEqualTo(54.5);
        assertThat(location.getLongitude()).isEqualTo(18.5);
        verify(locationRepository).save(any());
    }

}
