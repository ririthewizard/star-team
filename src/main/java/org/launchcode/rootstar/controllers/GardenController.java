package org.launchcode.rootstar.controllers;

import org.launchcode.rootstar.models.Garden;
import org.launchcode.rootstar.models.Plant;
import org.launchcode.rootstar.models.data.GardenRepository;
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
        Integer soilId = (Integer) garden.get("gardenSoil");
        List<Integer> plants = (List<Integer>) garden.get("gardenPlants");
        List<Integer> seeds = (List<Integer>) garden.get("gardenSeeds");

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
