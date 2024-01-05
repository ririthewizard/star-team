package org.launchcode.rootstar.service;

import org.launchcode.rootstar.service.models.Plant;
import org.launchcode.rootstar.service.models.data.PlantRepository;
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

    public Plant addPlant(Plant plant) {
        return plantRepository.save(plant);
    }

    // READ
    public Optional<Plant> getPlantById(int id) {
        return plantRepository.findById(id);
    }

    public List<Plant> getAllPlants(){
        return plantRepository.findAll();
    }

    public void deletePlant(int id) {
        plantRepository.deleteById(id);
    }

}
