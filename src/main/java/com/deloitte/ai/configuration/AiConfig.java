package com.deloitte.ai.configuration;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

	@Bean
	public OpenAiChatModel openAiChatModel(
		AiProperties properties
	) {
		return OpenAiChatModel.builder()
			.apiKey(properties.apiKey())
			.modelName(properties.model())
			.temperature(properties.temperature())
			.build();
	}
}