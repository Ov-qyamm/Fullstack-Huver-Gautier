package BackHuverGautier.DSBack.Repository;

import BackHuverGautier.DSBack.Entity.EvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Integer> {
}
