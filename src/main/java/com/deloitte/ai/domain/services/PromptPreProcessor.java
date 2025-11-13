package com.deloitte.ai.domain.services;

import com.deloitte.ai.domain.model.PreRequestContext;
import com.deloitte.ai.domain.model.User;

public interface PromptPreProcessor {
	PreRequestContext process(User user, String prompt);
}
