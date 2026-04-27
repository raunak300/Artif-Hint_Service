package com.rbm.artif.hint.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class QuestionDTO {
	String sessionId;
    Integer Hints;
    String Question;
    String prevSolution;
    UsersDTO user;
}
