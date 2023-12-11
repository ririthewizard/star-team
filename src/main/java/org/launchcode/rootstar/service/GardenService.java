package org.launchcode.rootstar.service;

import org.launchcode.rootstar.models.Garden;
import org.launchcode.rootstar.models.data.GardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GardenService {
    private final GardenRepository gardenRepository;

    // TBD If we want to use these
//    private final PlantRepository plantRepository;
//    private final SeedRepository seedRepository;
//    private final SoilRepository soilRepository;

    @Autowired
    public GardenService(GardenRepository gardenRepository) {
        this.gardenRepository = gardenRepository;
    }

    // CRUD operations for Garden class

    // CREATE
    public Garden createGarden(Garden garden) {
        return gardenRepository.save(garden);
    }

    // READ
    public Optional<Garden> getGardenById(int id) {
        return gardenRepository.findById(id);
    }

    public List<Garden> getAllGardens() {
        return gardenRepository.findAll();
    }

    // TODO: UPDATE


    // DELETE
    public void deleteGarden(int id) {
        gardenRepository.deleteById(id);
    }

}