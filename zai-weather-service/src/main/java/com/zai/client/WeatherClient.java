package com.zai.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.zai.model.WeatherResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse fetchFromWeatherStack(String ignored) {
        String city = "Aurangabad";
        String url = "http://api.weatherstack.com/current?access_key=9f1dd10a8091973d2518b9aae96af1c3&query=" + city;

        JsonNode root = restTemplate.getForObject(url, JsonNode.class);
        if (root != null && root.has("current") && root.get("current").has("temperature") && root.get("current").has("wind_speed")) {
            double temp = root.get("current").get("temperature").asDouble();
            double wind = root.get("current").get("wind_speed").asDouble();
            return new WeatherResponse(wind, temp);
        }
        throw new RuntimeException("WeatherStack response is invalid: " + root);
    }

    public WeatherResponse fetchFromOpenWeather(String ignored) {
        String city = "Aurangabad";
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + ",IN&appid=9f1dd10a8091973d2518b9aae96af1c3&units=metric";

        JsonNode root = restTemplate.getForObject(url, JsonNode.class);
        if (root != null && root.has("main") && root.get("main").has("temp") && root.get("wind").has("speed")) {
            double temp = root.get("main").get("temp").asDouble();
            double wind = root.get("wind").get("speed").asDouble();
            return new WeatherResponse(wind, temp);
        }
        throw new RuntimeException("OpenWeather response is invalid: " + root);
    }
}
