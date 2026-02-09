package com.example.jpa_liabrary.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Demo API to understand documentation",
                version = "1.0",
                description = "Product and consumer management system"
        )
)

public class OpenApiConfig {
}
