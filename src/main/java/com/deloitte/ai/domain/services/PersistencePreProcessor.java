package com.deloitte.ai.domain.services;

import com.deloitte.ai.dao.entity.UserEntity;
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
		UserEntity persistedUser = find(user.id());
		UserRequest request = new UserRequest(persistedUser.getId(), prompt);
		userRequestRepository.save(request);
		return new PreRequestContext(request.getId());
	}

	private UserEntity find(String id) {
		return userRepository.findById(id)
			.orElseGet(() -> userRepository.save(new UserEntity(id)));
	}
}
