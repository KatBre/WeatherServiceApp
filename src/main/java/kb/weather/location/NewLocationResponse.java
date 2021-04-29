package kb.weather.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class NewLocationResponse {
    private String id;
    private String city;
    private String region;
    private String country;
    private Double latitude;
    private Double longitude;
}