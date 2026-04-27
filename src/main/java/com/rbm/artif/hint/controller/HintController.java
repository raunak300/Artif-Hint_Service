package com.rbm.artif.hint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rbm.artif.hint.dto.InputDTO;

@Controller
@RequestMapping("/rbm/hint")
public class HintController {
	
	@PostMapping("/question")
	public void generateResult(InputDTO inpDTO) {
		//ai-agent call
		//store result in mdb
		//publish event in kafka
		//return response
	}
}
