package com.portafolio.backend.portafolio_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {


    @Bean
    public WebMvcConfigurer corsConfigure(){

        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry){

                registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "https://hector-gallego.github.io/portafolio/")
                .allowedMethods("GET")
                .allowedHeaders("*");

            }
        };
        
    }


    
}
