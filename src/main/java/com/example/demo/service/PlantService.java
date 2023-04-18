package com.example.demo.service;

import com.example.demo.entity.Plant;
import com.example.demo.entity.User;
import com.example.demo.repository.PlantRepository;
import com.example.demo.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class PlantService {
    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public List<Plant> findAllPlants() {
       return plantRepository.findAll();
    }

    public Plant findPlantById(int plantId) {
        Optional<Plant> selectedPlant = plantRepository.findById(plantId);
        return selectedPlant.orElse(null);
    }

    public void addNewPlant(@RequestBody Plant plant) {
        User user = userService.getUserFromSessionStorage();
        plant.setUser(user);
        plantRepository.save(plant);
    }



    public List<Plant> getAllOwnerPlants() {
        User user = userService.getUserFromSessionStorage();
        Optional<User> userByEmail = userRepository.findByEmail(user.getEmail());
         if (userByEmail.isPresent()){
             return userByEmail.get().getPlants();
         }
        throw new EntityNotFoundException();
    }

    public void waterSelectedPlant (int plantId) {
        LocalDate localDate = LocalDate.now();
        Optional<Plant> selectedPlant = plantRepository.findById(plantId);
                if(selectedPlant.isPresent()) {
                    Plant plantToWater = selectedPlant.get();
                    plantToWater.setLastWatered(localDate);
                    plantRepository.save(plantToWater);
                    return;
                }
        throw new EntityNotFoundException();
    }

    public void updatePlant() {
    }
}
