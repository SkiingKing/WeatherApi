package com.task.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.api.entity.ApiAuth;
import com.task.api.entity.WeatherResponse;
import org.springframework.stereotype.Service;
import org.testcontainers.shaded.okhttp3.OkHttpClient;
import org.testcontainers.shaded.okhttp3.Request;
import org.testcontainers.shaded.okhttp3.Response;
import org.testcontainers.shaded.okhttp3.ResponseBody;

import java.io.IOException;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final ApiAuth apiAuth;

    public WeatherServiceImpl(ApiAuth apiAuth) {
        this.apiAuth = apiAuth;
    }


    @Override
    public WeatherResponse fetchWeather(Double lat, Double lon) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://weatherbit-v1-mashape.p.rapidapi.com/forecast/minutely?lat=" + lat + "&lon=" + lon)
                .get()
                .addHeader("X-RapidAPI-Key", apiAuth.getKey())
                .addHeader("X-RapidAPI-Host", apiAuth.getHost())
                .build();

        Response response;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
           response = client.newCall(request).execute();
           ResponseBody responseBody = response.body();
           return responseBody != null ? objectMapper.readValue(responseBody.string(), WeatherResponse.class) : null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
