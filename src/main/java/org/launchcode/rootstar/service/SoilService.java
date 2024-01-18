package org.launchcode.rootstar.service;

import org.launchcode.rootstar.models.Soil;
import org.launchcode.rootstar.models.data.SoilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoilService {

    private final SoilRepository soilRepository;

    @Autowired
    public SoilService(SoilRepository soilRepository) {
        this.soilRepository = soilRepository;
    }

    // CRUD operations for Soil class

    // CREATE
    public Soil addSoil(Soil soil) {
        return soilRepository.save(soil);
    }

    // READ
    public Optional<Soil> getSoilById(int id) {
        return soilRepository.findById(id);
    }

    public List<Soil> getAllSoils() {
        return soilRepository.findAll();
    }

    // TODO: make UPDATE functionality for Soil

    // DELETE

    public void deleteSoil(int id) {
        soilRepository.deleteById(id);
    }
}
