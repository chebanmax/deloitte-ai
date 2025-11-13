package com.deloitte.ai.domain.services;

import com.deloitte.ai.domain.model.User;

public interface PromptPostProcessor {
	void process(User user, String requestId, String response);
}
