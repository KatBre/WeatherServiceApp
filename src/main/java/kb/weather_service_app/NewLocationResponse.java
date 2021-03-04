package kb.weather_service_app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewLocationResponse {
    private String city;
    private String region;
    private String country;
    private Double latitude;
    private Double longitude;
}
