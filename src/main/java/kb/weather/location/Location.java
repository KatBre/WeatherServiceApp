package kb.weather.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @Id
    private String uuid = UUID.randomUUID().toString();
    private String city;
    private String region;
    private String country;
    private Double latitude;
    private Double longitude;
}
