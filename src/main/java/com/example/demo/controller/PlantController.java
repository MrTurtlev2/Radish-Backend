package com.example.demo.controller;

import com.example.demo.entity.Plant;
import com.example.demo.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/plant")
public class PlantController {

    @Autowired
    PlantRepository plantRepository;

    @GetMapping("/all-plants")
    public List<Plant> getAllUserPlants() {
        return plantRepository.findAll();
    }

    @GetMapping("/plant-by-id/{id}")
    public Plant getUserPlantById(@PathVariable(name = "id") int plantId) {
        Optional<Plant> selectedPlant = plantRepository.findById(plantId);
        return selectedPlant.orElse(null);
    }

    @GetMapping("/plant-by-owner-id/{id}")
    public List<Plant> getPlantsByOwnerId(@PathVariable(name = "id") int ownerId) {
        return plantRepository.getPlantsByOwner(ownerId);
    }
}
