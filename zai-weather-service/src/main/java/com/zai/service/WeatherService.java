package com.zai.service;

import com.zai.client.WeatherClient;
import com.zai.model.WeatherResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherClient client;

    public WeatherService(WeatherClient client) {
        this.client = client;
    }

    @Cacheable(value = "weatherCache", key = "#city", unless = "#result == null")
    public WeatherResponse getWeather(String city) {
        try {
            return client.fetchFromWeatherStack(city);
        } catch (Exception e1) {
            try {
                return client.fetchFromOpenWeather(city);
            } catch (Exception e2) {
                throw new RuntimeException("Both providers failed.");
            }
        }
    }
}
