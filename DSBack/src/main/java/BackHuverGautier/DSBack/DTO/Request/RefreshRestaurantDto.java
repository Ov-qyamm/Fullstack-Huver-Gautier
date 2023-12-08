package BackHuverGautier.DSBack.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshRestaurantDto {

    @JsonProperty("titre")
    @Size(max=90)
    private String titre;

    @JsonProperty("adresse")
    @Size(max=255)
    private String adresse;

}

