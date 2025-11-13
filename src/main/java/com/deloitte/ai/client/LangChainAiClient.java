package com.deloitte.ai.client;

import com.deloitte.ai.domain.model.PromptResponse;
import com.deloitte.ai.domain.services.AiClient;
import org.springframework.stereotype.Service;

@Service
public class LangChainAiClient implements AiClient {
	@Override
	public PromptResponse prompt(String text) {
		return new PromptResponse("");
	}
}
