package kb.weather.location;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Builder
public class CreateLocationRequest {

    @NotBlank(message = "Empty city not accepted")
    private String city;
    private String region;
    @NotEmpty(message = "Empty country not accepted")
    private String country;
    @Min(value = -90, message = "Latitude out of range. Accepted value within the range -90 to 90.")
    @Max(value = 90, message = "Latitude out of range. Accepted value within the range -90 to 90.")
    private Double latitude;
    @Min(value = -180, message = "Longitude out of range. Accepted value within the range -180 to 180.")
    @Max(value = 180, message = "Longitude out of range. Accepted value within the range -180 to 180.")
    private Double longitude;
}
