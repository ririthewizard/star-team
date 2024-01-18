package org.launchcode.rootstar.controllers;


import org.launchcode.rootstar.models.Garden;
import org.launchcode.rootstar.models.data.GardenRepository;
import org.launchcode.rootstar.service.SearchFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("search")
@CrossOrigin
public class SearchController {

    @Autowired
    private SearchFunctions searchFunctions;

    @Autowired
    private GardenRepository gardenRepository;

    @GetMapping("/byGarden")
    // method findGarden utilizes method findByValue from SearchFunctions.java line 46
    public ResponseEntity<List<Garden>> findGarden(@RequestParam String query) {
        List<Garden> searchResults = searchFunctions.findByValue(query, gardenRepository.findAll());
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

}