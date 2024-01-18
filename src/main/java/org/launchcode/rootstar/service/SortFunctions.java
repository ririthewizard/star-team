package org.launchcode.rootstar.service;

import org.launchcode.rootstar.service.models.Garden;
import org.launchcode.rootstar.service.models.data.GardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;
@Service
@CrossOrigin
public class SortFunctions {

    @Autowired
    private GardenRepository gardenRepository;
    public List<Garden> sortAscending() {
        Sort sort = Sort.by(Sort.Direction.ASC, "seed", "plant");
        return gardenRepository.findAll(sort);
    }

    public List<Garden> sortDescending() {
        Sort sort = Sort.by(Sort.Direction.DESC, "seed", "plant");
        return gardenRepository.findAll(sort);
    }
}
