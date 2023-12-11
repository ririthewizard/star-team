package org.launchcode.rootstar.controllers;

import org.launchcode.rootstar.models.data.GardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gardens")
public class GardenController {

    @Autowired
    private GardenRepository gardenRepository;

}
