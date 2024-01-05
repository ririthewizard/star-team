package org.launchcode.rootstar.service;

import org.launchcode.rootstar.service.models.Garden;
import org.launchcode.rootstar.service.models.data.GardenRepository;
import org.springframework.data.domain.Sort;

import java.util.*;

public class SortFunctions {
    public List<Garden> sortAscending() {
        Sort sort = Sort.by(Sort.Direction.ASC, "seed", "plant");
        List<Garden> gardens = GardenRepository.findAll(sort);


    }
}
