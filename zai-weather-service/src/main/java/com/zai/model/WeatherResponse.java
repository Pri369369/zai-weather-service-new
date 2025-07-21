package com.zai.model;

public class WeatherResponse {
    private double windSpeed;
    private double temperatureDegrees;

    public WeatherResponse(double windSpeed, double temperatureDegrees) {
        this.windSpeed = windSpeed;
        this.temperatureDegrees = temperatureDegrees;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getTemperatureDegrees() {
        return temperatureDegrees;
    }
}
