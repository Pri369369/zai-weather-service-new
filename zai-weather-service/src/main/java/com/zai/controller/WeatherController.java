package com.zai.controller;

import com.zai.model.WeatherResponse;
import com.zai.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping
    public WeatherResponse getWeather(@RequestParam(defaultValue = "melbourne") String city) {
        return service.getWeather(city);
    }
}
