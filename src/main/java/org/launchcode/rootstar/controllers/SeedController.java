package org.launchcode.rootstar.controllers;

import org.launchcode.rootstar.models.Seed;
import org.launchcode.rootstar.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
