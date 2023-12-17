package org.launchcode.rootstar.controllers;

import org.launchcode.rootstar.models.data.SoilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("soil")
public class SoilController {

    @Autowired
    private SoilRepository soilRepository;
}
