package com.deloitte.ai.client;

import com.deloitte.ai.domain.model.PromptResponse;
import com.deloitte.ai.domain.services.AiClient;
import dev.langchain4j.model.openai.OpenAiChatModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LangChainAiClient implements AiClient {

	private final OpenAiChatModel model;

	@Override
	public PromptResponse chat(String text) {
		try {
			return new PromptResponse(model.generate(text));
		} catch (Exception e) {
			log.error(e.getMessage());
			return new PromptResponse(e.getMessage());
		}
	}
}
