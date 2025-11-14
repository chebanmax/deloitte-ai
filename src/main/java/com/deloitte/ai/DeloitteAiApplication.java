package com.deloitte.ai;

import com.deloitte.ai.configuration.AiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(AiProperties.class)
@SpringBootApplication
public class DeloitteAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeloitteAiApplication.class, args);
	}

}
