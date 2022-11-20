package com.task.api.controller;


import com.task.api.entity.WeatherResponse;
import com.task.api.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiController {

    private final WeatherService weatherService;

    public ApiController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("weatherByCordinate")
    public ResponseEntity<WeatherResponse> getWeatherByCoordinate(@RequestParam Double lat, @RequestParam Double lon){
        log.info("1 Hour / Minutely Forecast (Nowcast)");
        return new ResponseEntity<>(weatherService.fetchWeather(lat, lon), HttpStatus.OK);
    }
}
