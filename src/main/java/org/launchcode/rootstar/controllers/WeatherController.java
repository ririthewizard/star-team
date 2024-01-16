package org.launchcode.rootstar.controllers;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.launchcode.rootstar.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/forecast")
    public JSONObject getFiveDay(String postalCode){
        String locationKey = weatherService.getLocationData(postalCode);
        return weatherService.getWeatherData(locationKey);
//        return null;
    }
}
