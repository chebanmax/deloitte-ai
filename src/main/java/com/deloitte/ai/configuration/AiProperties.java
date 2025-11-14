package com.deloitte.ai.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.ai")
public record AiProperties(
        String apiKey,
        String model,
        double temperature
) {}