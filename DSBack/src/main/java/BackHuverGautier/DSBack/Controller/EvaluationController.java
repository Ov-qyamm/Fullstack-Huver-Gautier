package BackHuverGautier.DSBack.Controller;

import BackHuverGautier.DSBack.DTO.Request.AddEvaluationDto;
import BackHuverGautier.DSBack.DTO.Response.EvaluationDto;
import BackHuverGautier.DSBack.Services.EvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping("/restaurants/{restaurantId}/evaluations")
    public EvaluationDto addEvaluation(@PathVariable Integer restaurantId, @Valid @RequestBody AddEvaluationDto addEvaluationDto) {
        return EvaluationDto.buildFromEntity(this.evaluationService.addEvaluationToRestaurant(restaurantId, addEvaluationDto));
    }

    @DeleteMapping("/restaurants/{restaurantId}/evaluations/{id}")
    public void deleteEvaluation(@PathVariable Integer id) {
        this.evaluationService.deleteEvaluation(id);
    }

}

