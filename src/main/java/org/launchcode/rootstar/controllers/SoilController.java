package org.launchcode.rootstar.controllers;

import org.launchcode.rootstar.service.models.Soil;
import org.launchcode.rootstar.service.SoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("soil")
@CrossOrigin
public class SoilController {

    @Autowired
    private SoilService soilService;

    // GET MAPPING
    @GetMapping("/{id}")
    // Returns 200 OK HTTP Response (headers, status, and body) for soil if found, 404 if not
    public ResponseEntity<Soil> getSoilById(@PathVariable int id) {
        Optional<Soil> soil = soilService.getSoilById(id);
        return soil.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("view-soils")
    // Returns all soils in repository
    public List<Soil> viewSoils() {
        return soilService.getAllSoils();
    }

    // POST MAPPING
    @PostMapping("/add")
    // Returns a response entity with Uniform Resource Identifier with new soil ID and Body
    public ResponseEntity<Soil> addSoil(@RequestBody Soil soil) throws URISyntaxException {
        Soil savedSoil = soilService.addSoil(soil);
        return ResponseEntity.created(new URI("/soil/" + savedSoil.getId())).body(savedSoil);
    }

    // DELETE MAPPING
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSoil(@PathVariable int id) {
        soilService.deleteSoil(id);
        return ResponseEntity.ok().build();
    }
}
