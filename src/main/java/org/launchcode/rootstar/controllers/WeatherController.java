package org.launchcode.rootstar.controllers;


import com.google.gson.JsonObject;
import org.launchcode.rootstar.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("weather")
@CrossOrigin
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("forecast")
    public ResponseEntity<String> getFiveDay(@RequestParam String q) {
        JsonObject forecast = weatherService.getWeatherData(q);
        String jsonString = forecast.toString();
        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }
}
