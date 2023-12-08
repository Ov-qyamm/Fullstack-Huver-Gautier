package BackHuverGautier.DSBack.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddEvaluationDto {

    @JsonProperty("texte")
    @Size(max=255)
    private String texte;

    @JsonProperty("pseudo")
    @Size(max=50)
    private String pseudo;

    @JsonProperty("note")
    @Min(0)
    @Max(3)
    private int note;

}
