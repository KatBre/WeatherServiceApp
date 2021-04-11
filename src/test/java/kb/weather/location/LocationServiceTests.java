package kb.weather.location;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import javax.lang.model.util.Types;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LocationServiceTests {
    @Mock
    LocationRepository locationRepository;
    @InjectMocks
    LocationService locationService;
    @Captor
    ArgumentCaptor<Location> locationArgumentCaptor;

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
        verify(locationRepository).save(locationArgumentCaptor.capture());
        assertThat(location.getCity()).isEqualTo("Gdynia");
        assertThat(location.getRegion()).isEqualTo("pomeranian");
        assertThat(location.getCountry()).isEqualTo("Poland");
        assertThat(location.getLatitude()).isEqualTo(54.5);
        assertThat(location.getLongitude()).isEqualTo(18.5);
        verify(locationRepository).save(any());
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
        assertThat(location.getRegion()).isEqualTo(" ");
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
        verify(locationRepository).save(locationArgumentCaptor.capture());
        assertThat(location.getCity()).isEqualTo("Gdynia");
        assertThat(location.getRegion()).isEqualTo(null);
        assertThat(location.getCountry()).isEqualTo("Poland");
        assertThat(location.getLatitude()).isEqualTo(54.5);
        assertThat(location.getLongitude()).isEqualTo(18.5);
        verify(locationRepository).save(any());
    }
}
