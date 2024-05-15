package com.example.demo.configuration;

import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Logger;

@Configuration
public class CorsConfig {





    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//
//                        .allowedOriginPatterns("*") // Allow requests from any origin
//                        .allowedMethods("*") // Allow all HTTP methods
//                        .allowedHeaders("*")
//                        .allowCredentials(true);
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowedOrigins("http://localhost:3000","http://localhost:8080");
                WebMvcConfigurer.super.addCorsMappings(registry);

            }
        };
    }
}