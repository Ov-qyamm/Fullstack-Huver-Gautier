package BackHuverGautier.DSBack.DTO.Response;

import BackHuverGautier.DSBack.Entity.RestaurantEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("titre")
    private String titre;

    @JsonProperty("adresse")
    private String adresse;

    @JsonProperty("evaluations")
    private List<EvaluationDto> evaluations;

    @JsonProperty("evaluationFinale")
    private EvaluationFinaleDto evaluationFinale;

    @JsonProperty("moyenne")
    private double moyenne;

/*
    @JsonProperty("tags")
    private List<Boolean> tags;
*/

    public static RestaurantDto buildFromEntity(RestaurantEntity restaurantEntity) {
        return RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .titre(restaurantEntity.getTitre())
                .adresse(restaurantEntity.getAdresse())
                .evaluations(restaurantEntity.getEvaluations() != null ? restaurantEntity.getEvaluations().stream().map(evaluationEntity -> EvaluationDto.buildFromEntity(evaluationEntity)).toList() : new ArrayList<>())
                .moyenne(restaurantEntity.getEvaluations().stream().mapToInt(evaluationEntity->evaluationEntity.getNote()).average().orElse(-1))
                .evaluationFinale(restaurantEntity.getEvaluationFinale()!= null ? EvaluationFinaleDto.buildFromEntity(restaurantEntity.getEvaluationFinale()) :new EvaluationFinaleDto())
                .build();
    }

}

