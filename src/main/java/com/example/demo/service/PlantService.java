package com.example.demo.service;

import com.example.demo.entity.Plant;
import com.example.demo.repository.PlantRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class PlantService {
    @Autowired
    private PlantRepository plantRepository;

    public List<Plant> findAllPlants() {
       return plantRepository.findAll();
    }

    public Plant findPlantById(int plantId) {
        Optional<Plant> selectedPlant = plantRepository.findById(plantId);
        return selectedPlant.orElse(null);
    }
    public List<Plant> getAllOwnerPlants(int ownerId) {
        return plantRepository.getPlantsByOwner(ownerId);
    }
    public void waterSelectedPlant (int plantId) {
        LocalDate localDate = LocalDate.now();
        Plant selectedPlant = plantRepository.findById(plantId).get();
            selectedPlant.setLastWatered(localDate);
            plantRepository.save(selectedPlant);
    }
}
