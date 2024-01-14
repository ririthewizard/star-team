package org.launchcode.rootstar.service;

import jakarta.transaction.Transactional;
import org.launchcode.rootstar.models.Garden;
import org.launchcode.rootstar.models.Plant;
import org.launchcode.rootstar.models.Seed;
import org.launchcode.rootstar.models.Soil;
import org.launchcode.rootstar.data.GardenRepository;
import org.launchcode.rootstar.data.PlantRepository;
import org.launchcode.rootstar.data.SeedRepository;
import org.launchcode.rootstar.data.SoilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class GardenService {
    private final GardenRepository gardenRepository;

    private final SeedRepository seedRepository;

    private final SoilRepository soilRepository;

    private final PlantRepository plantRepository;

    @Autowired
    public GardenService(GardenRepository gardenRepository, SeedRepository seedRepository, SoilRepository soilRepository, PlantRepository plantRepository) {
        this.gardenRepository = gardenRepository;
        this.seedRepository = seedRepository;
        this.soilRepository = soilRepository;
        this.plantRepository = plantRepository;
    }

    // CRUD operations for Garden class

    // CREATE
    public Garden addGarden(String name, String description, int soilId, List<Integer> plants, List<Integer> seeds) {
        Garden garden = new Garden();
        garden.setName(name);
        garden.setDescription(description);
        Optional<Soil> result = soilRepository.findById(soilId);
        if (result.isEmpty()) {
            System.out.println("Invalid soil: " + soilId);
        } else {
            Soil soil = result.get();
            garden.setGardenSoil(soil);
        }
        List<Seed> seedObj = (List<Seed>) seedRepository.findAllById(seeds);
        garden.setGardenSeeds(seedObj);
        List<Plant> plantObj = (List<Plant>) plantRepository.findAllById(plants);
        garden.setGardenPlants(plantObj);
        return gardenRepository.save(garden);
    }

    // READ
    public Optional<Garden> getGardenById(int id) {
        return gardenRepository.findById(id);
    }

    public List<Garden> getAllGardens() {
        return gardenRepository.findAll();
    }

    // UPDATE
    public Garden updateGarden(int id, Garden newGarden) {
        Garden updatedGarden = gardenRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Garden with id " + id + " not found"));
        updatedGarden.setName(newGarden.getName());
        updatedGarden.setDescription(newGarden.getDescription());
        updatedGarden.setGardenSeeds(newGarden.getGardenSeeds());
        updatedGarden.setGardenPlants(newGarden.getGardenPlants());
        updatedGarden.setGardenSoil(newGarden.getGardenSoil());
        return gardenRepository.save(updatedGarden);
    }

    // DELETE
    public void deleteGarden(int id) {
        gardenRepository.deleteById(id);
    }

}