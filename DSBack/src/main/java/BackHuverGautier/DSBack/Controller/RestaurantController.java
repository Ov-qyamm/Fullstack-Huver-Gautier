package BackHuverGautier.DSBack.Controller;

import BackHuverGautier.DSBack.DTO.Request.RefreshRestaurantDto;
import BackHuverGautier.DSBack.DTO.Response.RestaurantDto;
import BackHuverGautier.DSBack.DTO.Request.AddRestaurantDto;
import BackHuverGautier.DSBack.Services.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantDto> getRestaurants(@RequestParam(value = "id", required = false) ArrayList<Integer> idsToFetch) {
        if (idsToFetch == null || idsToFetch.isEmpty()) {
            return this.restaurantService.getRestaurants().stream().map(restaurantEntity -> RestaurantDto.buildFromEntity(restaurantEntity)).toList();
        } else {
            return this.restaurantService.getRestaurants(idsToFetch).stream().map(restaurantEntity -> RestaurantDto.buildFromEntity(restaurantEntity)).toList();
        }
    }

    @GetMapping("/restaurants/{id}")
    public RestaurantDto getRestaurantById(@PathVariable Integer id) {
        return RestaurantDto.buildFromEntity(this.restaurantService.getRestaurantById(id));
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/restaurants")
    public RestaurantDto addRestaurant(@Valid @RequestBody AddRestaurantDto restaurantDto) {
        return RestaurantDto.buildFromEntity(this.restaurantService.addRestaurant(restaurantDto));
    }

    @DeleteMapping("/restaurants/{id}")
    public void deleteRestaurant(@PathVariable Integer id) {
        this.restaurantService.deleteRestaurant(id);
    }

    @PutMapping("/restaurants/{id}")
    public RestaurantDto RefreshRestaurant(@Valid @PathVariable Integer id, @Valid @RequestBody RefreshRestaurantDto restaurantDto) {
        return RestaurantDto.buildFromEntity(this.restaurantService.RefreshRestaurant(id, restaurantDto.getTitre(), restaurantDto.getAdresse()));
    }
}

