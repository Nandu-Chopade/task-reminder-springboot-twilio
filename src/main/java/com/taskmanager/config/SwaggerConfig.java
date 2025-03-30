package com.taskmanager.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Task Reminder API",
        version = "1.0.0",
        description = "A simple task reminder system using Twilio and Spring Boot.",
        contact = @Contact(
            name = "Nandu Chopade",
            url = "https://github.com/Nandu-Chopade",
            email = "nandu@example.com"
        )
    )
)
public class SwaggerConfig {
}
