package org.launchcode.rootstar.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.launchcode.rootstar.service.models.Garden;
import org.launchcode.rootstar.service.models.data.GardenRepository;
import org.launchcode.rootstar.service.GardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("gardens")
@CrossOrigin
public class GardenController {

    @Autowired
    private GardenService gardenService;

    @Autowired
    private GardenRepository gardenRepository;

    @Autowired
    private ObjectMapper objectMapper;

    // GET MAPPING
    @GetMapping("/{id}")
    // Returns 200 OK HTTP Response (headers, status, and body) for garden if found, 404 if not
    public ResponseEntity<Garden> getGardenById(@PathVariable int id) {
        Optional<Garden> garden = gardenService.getGardenById(id);
        return garden.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("view-gardens")
    // Returns all gardens in repository
    public List<Garden> viewGardens() {
        return gardenService.getAllGardens();
    }

    // POST MAPPING
    @PostMapping("/add")
    // Returns a response entity with Uniform Resource Identifier with new garden ID and Body
    public ResponseEntity<Garden> addGarden(@RequestBody Map<String, Object> garden) throws URISyntaxException {
        String name = (String) garden.get("name");
        String description = (String) garden.get("description");

        // Basically Jackson, the Java library which deserializes the JSON objects, needs to be explictly told
        // what type they are. That is what these object mapper methods accomplish.
        Integer soilId = objectMapper.convertValue(garden.get("gardenSoil"), Integer.class);
        List<Integer> plants = objectMapper.convertValue(garden.get("gardenPlants"), new TypeReference<List<Integer>>() {});
        List<Integer> seeds = objectMapper.convertValue(garden.get("gardenSeeds"), new TypeReference<List<Integer>>() {});

        Garden savedGarden = gardenService.addGarden(name, description, soilId, plants, seeds);
        return ResponseEntity.created(new URI("/gardens/" + savedGarden.getId())).body(savedGarden);
    }

    @PutMapping("/{id}")
    // Updates garden
    // Returns a 204 No Content response, so user does not need to navigate away from page and can keep updating.
    public ResponseEntity<Void> updateGarden(@PathVariable int id, @RequestBody Garden newGarden) {
        gardenService.updateGarden(id, newGarden);
        return ResponseEntity.noContent().build();
    }

    // DELETE MAPPING
    @DeleteMapping("/{id}")
    public ResponseEntity deleteGarden(@PathVariable int id) {
        gardenService.deleteGarden(id);
        return ResponseEntity.ok().build();
    }

}
