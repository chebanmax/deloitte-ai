package com.deloitte.ai.domain.services;

import com.deloitte.ai.dao.entity.UserResponse;
import com.deloitte.ai.dao.repository.UserRequestRepository;
import com.deloitte.ai.dao.repository.UserResponseRepository;
import com.deloitte.ai.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersistencePostProcessor implements PromptPostProcessor {

	private final UserRequestRepository userRequestRepository;
	private final UserResponseRepository userResponseRepository;

	@Override
	public void process(User user, String requestId, String response) {
		userRequestRepository.findById(requestId)
			.map(userRequest -> new UserResponse(user.id(), userRequest.getId(), response))
			.ifPresent(userResponseRepository::save);
	}
}
