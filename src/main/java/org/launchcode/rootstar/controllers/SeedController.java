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
    // Returns 200 OK HTTP Response (headers, status, and body) for seed if found, 404 if not
    public ResponseEntity<Seed> getSeedById(@PathVariable int id) {
        Optional<Seed> seed = seedService.getSeedById(id);
        return seed.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("view-seeds")
    // Returns all seeds in repository
    public List<Seed> viewSeeds() {
        return seedService.getAllSeeds();
    }

    // POST MAPPING
    @PostMapping("/add")
    // Returns a response entity with Uniform Resource Identifier with new seed ID and Body
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
