package com.deloitte.ai.web;

import com.deloitte.ai.domain.model.PromptRequest;
import com.deloitte.ai.domain.model.PromptResponse;
import com.deloitte.ai.facade.AiFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class AiRestController {

	private final AiFacade aiFacade;

	@PostMapping("/chat")
	PromptResponse chat(@RequestBody PromptRequest request) {
		return aiFacade.send(request);
	}
}
