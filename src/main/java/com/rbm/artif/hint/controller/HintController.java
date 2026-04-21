package com.rbm.artif.hint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rbm.artif.hint.dto.QuestionDTO;

@Controller
@RequestMapping("/rbm/hint")
public class HintController {
	
	@PostMapping("/question")
	public void generateResult(QuestionDTO quesDTO) {
		// get the question
		//extract user,role
		// check limit-redis
		//validate session in db
		//ai-agent call
		//store result in mdb
		//publish event in kafka
		//return response
	}
}
