package BackHuverGautier.DSBack.Services;

import BackHuverGautier.DSBack.DTO.Request.AddEvaluationDto;
import BackHuverGautier.DSBack.Entity.EvaluationEntity;
import BackHuverGautier.DSBack.Entity.RestaurantEntity;
import BackHuverGautier.DSBack.Repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final RestaurantService restaurantService;

    public EvaluationEntity addEvaluationToRestaurant(final Integer restaurantId, final AddEvaluationDto dto) {
        final RestaurantEntity restaurant = this.restaurantService.getRestaurantById(restaurantId);

        final EvaluationEntity evaluation = EvaluationEntity.builder()
                .texte(dto.getTexte())
                .restaurant(restaurant)
                .pseudo(dto.getPseudo())
                .note(dto.getNote())
                .build();

        return this.evaluationRepository.save(evaluation);
    }

    public void deleteEvaluation(final Integer id) {
        this.evaluationRepository.deleteById(id);
    }

}
