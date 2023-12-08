package BackHuverGautier.DSBack.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "evaluationFinale")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationFinaleEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "texteFinal", columnDefinition = "TEXT")
    private String texteFinal;

    @OneToOne()
    @JoinColumn(name = "evaluationFinale")
    private RestaurantEntity evaluationFinale;

    @Column(name = "pseudoFinal")
    private String pseudoFinal;

    @Column(name = "noteFinale")
    @Min(0)
    @Max(3)
    private int noteFinale;

}
