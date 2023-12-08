package BackHuverGautier.DSBack.DTO.Response;

import BackHuverGautier.DSBack.Entity.EvaluationFinaleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationFinaleDto {

    private Integer id;

    private String pseudoFinal;

    private String texteFinal;

    private int noteFinale;

    public static EvaluationFinaleDto buildFromEntity(EvaluationFinaleEntity evaluationFinaleEntity) {
        return EvaluationFinaleDto.builder()
                .id(evaluationFinaleEntity.getId())
                .pseudoFinal(evaluationFinaleEntity.getPseudoFinal())
                .texteFinal(evaluationFinaleEntity.getTexteFinal())
                .noteFinale(evaluationFinaleEntity.getNoteFinale())
                .build();
    }

}
