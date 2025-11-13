package com.deloitte.ai.facade;

import com.deloitte.ai.domain.model.PreRequestContext;
import com.deloitte.ai.domain.model.PromptRequest;
import com.deloitte.ai.domain.model.PromptResponse;
import com.deloitte.ai.domain.model.User;
import com.deloitte.ai.domain.services.AiClient;
import com.deloitte.ai.domain.services.PromptPostProcessor;
import com.deloitte.ai.domain.services.PromptPreProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class DefaultAiFacade implements AiFacade {

	private final PromptPreProcessor promptPreProcessor;
	private final AiClient aiClient;
	private final PromptPostProcessor promptPostProcessor;

	@Override
	public PromptResponse send(PromptRequest promptRequest) {
		User user = promptRequest.user();
		String requestPrompt = promptRequest.text();

		PreRequestContext preContext = promptPreProcessor.process(user, requestPrompt);
		PromptResponse response = aiClient.prompt(requestPrompt);
		promptPostProcessor.process(user, preContext.requestId(), response.text());

		return response;
	}
}
