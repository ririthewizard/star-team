package org.launchcode.rootstar.controllers;

import org.launchcode.rootstar.models.data.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("plants")
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

}
