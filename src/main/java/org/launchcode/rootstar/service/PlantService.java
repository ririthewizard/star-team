package org.launchcode.rootstar.service;

import org.launchcode.rootstar.models.Plant;
import org.launchcode.rootstar.models.data.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    // CRUD operations for Plant class

    // CREATE

    public Plant createPlant(Plant plant) {
        return plantRepository.save(plant);
    }

    // READ
    public Optional<Plant> getPlantById(int id) {
        return plantRepository.findById(id);
    }

    public List<Plant> getAllPlants(){
        return plantRepository.findAll();
    }

    // TODO: make UPDATE functionality for Plant

    public void deletePlant(int id) {
        plantRepository.deleteById(id);
    }

}
