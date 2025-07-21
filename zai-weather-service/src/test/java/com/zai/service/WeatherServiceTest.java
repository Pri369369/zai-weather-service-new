package com.zai.service;
import com.zai.model.WeatherResponse;
import com.zai.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
class WeatherServiceTest {

    @Autowired
    private WeatherService service;

    @Test
    void testWeatherFallbackToOpenWeather() {
        WeatherResponse response = service.getWeather("aurangabad");
        assertNotNull(response);
        assertTrue(response.getTemperatureDegrees() >= -20);
    }
}
