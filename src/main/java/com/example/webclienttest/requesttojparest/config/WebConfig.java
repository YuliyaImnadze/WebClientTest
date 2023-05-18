package com.example.webclienttest.requesttojparest.config;

import com.example.webclienttest.requesttojparest.v1.service.EmployeeServiceDTOClientV1;
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
        WebClient webClient = WebClient.create(baseUrl);
        return webClient;
    }


}
