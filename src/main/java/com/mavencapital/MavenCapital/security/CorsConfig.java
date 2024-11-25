package com.mavencapital.MavenCapital.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            
            @SuppressWarnings("null")
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Use correct syntax here
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedOrigins("*"); // Allow all origins, or specify specific ones as needed
            }
        };
    }
}