package com.deloitte.ai.domain.services;

import com.deloitte.ai.domain.model.PromptResponse;

public interface AiClient {
	PromptResponse chat(String text);
}
