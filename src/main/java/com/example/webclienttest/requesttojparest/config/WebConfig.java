package com.example.webclienttest.requesttojparest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

    @Value("${baseUrl}${port}${version1}")
    private String baseUrl;


    @Bean
    public WebClient createWebClient() {
        return WebClient.create(baseUrl);
    }


}
