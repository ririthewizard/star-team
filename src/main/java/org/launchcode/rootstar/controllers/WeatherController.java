package org.launchcode.rootstar.controllers;


import com.google.gson.JsonObject;
import org.launchcode.rootstar.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
@CrossOrigin
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("forecast")
    public ResponseEntity<String> getFiveDay(String postalCode) {
        System.out.println(postalCode);
        JsonObject forecast = weatherService.getWeatherData(postalCode);
        String jsonString = forecast.toString();

        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }
}
