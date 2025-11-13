package com.deloitte.ai.domain.services;

import com.deloitte.ai.dao.entity.UserRequest;
import com.deloitte.ai.dao.repository.UserRepository;
import com.deloitte.ai.dao.repository.UserRequestRepository;
import com.deloitte.ai.domain.model.PreRequestContext;
import com.deloitte.ai.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersistencePreProcessor implements PromptPreProcessor {

	private final UserRepository userRepository;
	private final UserRequestRepository userRequestRepository;

	@Override
	public PreRequestContext process(User user, String prompt) {
		return userRepository.findById(user.id())
			.map(persistedUser -> new UserRequest(persistedUser.getId(), prompt))
			.map(userRequestRepository::save)
			.map(request -> new PreRequestContext(request.getId()))
			.orElseThrow();
	}
}
