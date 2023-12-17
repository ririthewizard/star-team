package org.launchcode.rootstar.service;

import org.launchcode.rootstar.models.Garden;
import org.launchcode.rootstar.models.data.GardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GardenService {
    private final GardenRepository gardenRepository;

    @Autowired
    public GardenService(GardenRepository gardenRepository) {
        this.gardenRepository = gardenRepository;
    }

    // CRUD operations for Garden class

    // CREATE
    public Garden addGarden(Garden garden) {
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
        updatedGarden.setSeeds(newGarden.getSeeds());
        updatedGarden.setPlants(newGarden.getPlants());
        updatedGarden.setSoil(newGarden.getSoil());
        return gardenRepository.save(updatedGarden);
    }

    // DELETE
    public void deleteGarden(int id) {
        gardenRepository.deleteById(id);
    }

}