package com.example.demo.controller;

import com.example.demo.entity.Plant;
import com.example.demo.repository.PlantRepository;
import com.example.demo.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/plant")
public class PlantController {

    @Autowired
    PlantService plantService;

    @GetMapping("/all-plants")
    public List<Plant> getAllUserPlants() {
        return plantService.findAllPlants();
    }

    @GetMapping("/plant-by-id/{id}")
    public Plant getUserPlantById(@PathVariable(name = "id") int plantId) {
        return plantService.findPlantById(plantId);
    }

    @GetMapping("/plant-by-owner")
    public List<Plant> getPlantsByOwnerId() {
        return plantService.getAllOwnerPlants();
    }

    @PostMapping("/add")
    public void addPlant(@RequestBody Plant plant) {
        plantService.addNewPlant(plant);
    }

    @PutMapping("/water-plant/{plantId}")
    public void waterPlant(@PathVariable(name = "plantId") int plantId) throws Exception {
       plantService.waterSelectedPlant(plantId);
    }

}
