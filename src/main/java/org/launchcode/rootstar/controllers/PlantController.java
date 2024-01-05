package org.launchcode.rootstar.controllers;

import org.launchcode.rootstar.service.models.Plant;
import org.launchcode.rootstar.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("plants")
@CrossOrigin
public class PlantController {

    @Autowired
    private PlantService plantService;

    // GET MAPPING
    @GetMapping("/{id}")
    // Returns 200 OK HTTP Response (headers, status, and body) for plant if found, 404 if not
    public ResponseEntity<Plant> getPlantById(@PathVariable int id) {
        Optional<Plant> plant = plantService.getPlantById(id);
        return plant.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("view-plants")
    // Returns all plants in repository
    public List<Plant> viewPlants() {
        return plantService.getAllPlants();
    }

    // POST MAPPING
    @PostMapping("/add")
    // Returns a response entity with Uniform Resource Identifier with new plant ID and Body
    public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) throws URISyntaxException {
        Plant savedPlant = plantService.addPlant(plant);
        return ResponseEntity.created(new URI("/plants/" + savedPlant.getId())).body(savedPlant);
    }

    // DELETE MAPPING
    @DeleteMapping("/{id}")
    public ResponseEntity deletePlant(@PathVariable int id) {
        plantService.deletePlant(id);
        return ResponseEntity.ok().build();
    }

}
