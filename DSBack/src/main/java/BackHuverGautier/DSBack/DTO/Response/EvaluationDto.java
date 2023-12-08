package BackHuverGautier.DSBack.DTO.Response;

import BackHuverGautier.DSBack.Entity.EvaluationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationDto {

    private Integer id;

    private String pseudo;

    private String texte;

    private int note;

    public static EvaluationDto buildFromEntity(EvaluationEntity evaluationEntity) {
        return EvaluationDto.builder()
                .id(evaluationEntity.getId())
                .pseudo(evaluationEntity.getPseudo())
                .texte(evaluationEntity.getTexte())
                .note(evaluationEntity.getNote())
                .build();
    }

}
