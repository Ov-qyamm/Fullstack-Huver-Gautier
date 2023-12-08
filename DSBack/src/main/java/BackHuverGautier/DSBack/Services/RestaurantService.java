package BackHuverGautier.DSBack.Services;

import BackHuverGautier.DSBack.DTO.Request.AddRestaurantDto;
import BackHuverGautier.DSBack.Entity.RestaurantEntity;
import BackHuverGautier.DSBack.Exception.InvalidValueException;
import BackHuverGautier.DSBack.Exception.ResourceNotFoundException;
import BackHuverGautier.DSBack.Repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantEntity> getRestaurants() {
        return this.restaurantRepository.findAll();
    }

    public List<RestaurantEntity> getRestaurants(final List<Integer> idsToFetch) {
        return this.restaurantRepository.findAllById(idsToFetch);
    }

    public RestaurantEntity getRestaurantById(final Integer id) {
        return this.restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + id + " + not found"));
    }

    public RestaurantEntity addRestaurant(final AddRestaurantDto restaurantDto) {
        final RestaurantEntity restaurantToInsert = RestaurantEntity.builder()
                .titre(restaurantDto.getTitre())
                .adresse(restaurantDto.getAdresse())
                .build();

        return this.restaurantRepository.save(restaurantToInsert);
    }

    public void deleteRestaurant(final Integer id) {
        this.restaurantRepository.deleteById(id);
    }

    public RestaurantEntity RefreshRestaurant(int id, String nouveauNom, String nouvelleAdresse) {
        if (nouveauNom == null) {
            throw new InvalidValueException("le nouveau nom ne doit pas être null");
        }
        final RestaurantEntity restaurantToUpdate = this.restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("le restaurant d'id " + id + " n'existe pas"));
        restaurantToUpdate.setTitre(nouveauNom);
        restaurantToUpdate.setAdresse(nouvelleAdresse);
        restaurantRepository.save(restaurantToUpdate);
        return restaurantToUpdate;
    }

}
