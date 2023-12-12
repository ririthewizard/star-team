package org.launchcode.rootstar.service;

import org.launchcode.rootstar.models.Seed;
import org.launchcode.rootstar.models.data.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeedService {

    private final SeedRepository seedRepository;

    @Autowired
    public SeedService(SeedRepository seedRepository) {
        this.seedRepository = seedRepository;
    }

    // CRUD operations for Seed class

    // CREATE
    public Seed createSoil(Seed seed) {
        return seedRepository.save(seed);
    }

    // READ
    public Optional<Seed> getSeedById(int id) {
        return seedRepository.findById(id);
    }

    public List<Seed> getAllSeeds() {
        return seedRepository.findAll();
    }

    // TODO: make UPDATE functionality for Plant

    // DELETE
    public void deleteSeed(int id) {
        seedRepository.deleteById(id);
    }
}
