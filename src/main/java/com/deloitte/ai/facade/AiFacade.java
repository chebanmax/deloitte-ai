package com.deloitte.ai.facade;

import com.deloitte.ai.domain.model.PromptRequest;
import com.deloitte.ai.domain.model.PromptResponse;

public interface AiFacade {
	PromptResponse send(PromptRequest promptRequest);
}
