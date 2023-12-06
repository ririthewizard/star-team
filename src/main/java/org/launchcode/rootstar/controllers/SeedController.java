package org.launchcode.rootstar.controllers;

import org.launchcode.rootstar.models.data.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("seeds")
public class SeedController {

    @Autowired
    private SeedRepository seedRepository;


}
