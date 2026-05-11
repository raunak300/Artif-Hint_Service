package com.rbm.artif.hint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rbm.artif.hint.dto.InputDTO;
import services.ProvideHint;

@Controller
@RequestMapping("/rbm/hint")
public class HintController {

	@Autowired
	private ProvideHint provideHint;
	
	@PostMapping("/question")
	public void generateResult(InputDTO inpDTO) {

		provideHint.provideHint(inpDTO);
		//ai-agent call
		//store result in mdb
		//publish event in kafka
		//return response
	}
}
