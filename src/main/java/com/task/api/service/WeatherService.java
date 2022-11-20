package com.task.api.service;

import com.task.api.entity.WeatherResponse;

public interface WeatherService {

    WeatherResponse fetchWeather(Double lat, Double lon);
}
