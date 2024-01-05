package org.launchcode.rootstar.models;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.launchcode.rootstar.models.data.GardenRepository;
import org.springframework.data.domain.Sort;

import java.util.*;

public class SortFunctions {
    public List<Garden> sortAscending() {
        Sort sort = Sort.by(Sort.Direction.ASC, "seed", "plant");
        List<Garden> gardens = GardenRepository.findAll(sort);


    }
}
