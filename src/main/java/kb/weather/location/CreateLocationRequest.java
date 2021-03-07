package kb.weather.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLocationRequest {
    private String city;
    private String region;
    private String country;
    private Double latitude;
    private Double longitude;
}
