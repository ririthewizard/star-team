package org.launchcode.rootstar.controllers;

import org.launchcode.rootstar.models.Seed;
import org.launchcode.rootstar.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seeds")
public class SeedController {

    @Autowired
    public SeedService seedService;

    @PostMapping("/add")
    public String addSeed(@RequestBody Seed seed) {
        seedService.addSeed(seed);
        return "New seed is added.";
    }

    // TODO: Refactor if needed. This was how the YouTube video said to do it LOL
    @GetMapping("view-seeds")
    public List<Seed> viewSeeds() {
        return seedService.getAllSeeds();
    }
}
