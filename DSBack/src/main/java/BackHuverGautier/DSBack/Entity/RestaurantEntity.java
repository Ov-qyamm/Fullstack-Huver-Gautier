package BackHuverGautier.DSBack.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "titre", columnDefinition = "varchar(255)", nullable = false)
    private String titre;

    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "restaurant")
    private List<EvaluationEntity> evaluations;

    @OneToOne(mappedBy = "evaluationFinale")
    private EvaluationFinaleEntity evaluationFinale;

}
