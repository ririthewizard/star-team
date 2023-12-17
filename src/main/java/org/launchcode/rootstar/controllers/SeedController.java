package org.launchcode.rootstar.controllers;

import org.launchcode.rootstar.models.Seed;
import org.launchcode.rootstar.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seeds")
@CrossOrigin
public class SeedController {

    @Autowired
    public SeedService seedService;

    // GET MAPPING
    @GetMapping("/{id}")
    public ResponseEntity<Seed> getEventById(@PathVariable int id) {
        Optional<Seed> event = seedService.getSeedById(id);
        return event.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("view-seeds")
    public List<Seed> viewSeeds() {
        return seedService.getAllSeeds();
    }

    // POST MAPPING
    @PostMapping("/add")
    public ResponseEntity<Seed> addSeed(@RequestBody Seed seed) throws URISyntaxException {
        Seed savedSeed = seedService.addSeed(seed);
        return ResponseEntity.created(new URI("/seeds/" + savedSeed.getId())).body(savedSeed);
    }

    // DELETE MAPPING
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSeed(@PathVariable int id) {
        seedService.deleteSeed(id);
        return ResponseEntity.ok().build();
    }
}
