package com.task.api.config;


import com.task.api.entity.ApiAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherApiConfig {

    @Value("${x-repidApi-key}")
    private String RapidKey;


    @Value("${x-repidApi-host}")
    private String RapidHost;

    @Bean
    public ApiAuth getApiAuth() {
        ApiAuth apiAuth = new ApiAuth();
        apiAuth.setKey(RapidKey);
        apiAuth.setHost(RapidHost);
        return apiAuth;
    }
}
