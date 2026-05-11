package com.rbm.artif.hint.controller;

import com.rbm.artif.hint.dto.ResponseHintDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rbm.artif.hint.dto.InputDTO;
import com.rbm.artif.hint.services.ProvideHintImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hints")
public class HintController {

	@Autowired
	private ProvideHintImpl provideHint;
	
	@PostMapping("/getHint")
	public ResponseHintDTO generateResult(@RequestBody InputDTO inpDTO) {

		String output=provideHint.provideHint(inpDTO);
		ResponseHintDTO opt=new ResponseHintDTO();
		opt.setHintProvided(output);
		return opt;
		//ai-agent call
		//store result in mdb
		//publish event in kafka
		//return response
	}
}
