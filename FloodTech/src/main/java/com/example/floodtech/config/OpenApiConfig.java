package com.example.floodtech.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI floodTechOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("FloodTech API")
                        .version("1.0")
                        .description("Api para gestão de Usuarios e situações"));
    }
}
