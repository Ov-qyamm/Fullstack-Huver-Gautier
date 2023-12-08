package BackHuverGautier.DSBack.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "evaluations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "texte", columnDefinition = "TEXT")
    private String texte;

    @ManyToOne()
    @JoinColumn(name = "restaurant")
    private RestaurantEntity restaurant;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "note")
    private int note;

}

