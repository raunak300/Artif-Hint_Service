package com.rbm.artif.hint.dto;

import com.rbm.artif.hint.utilites.Premium;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class QuestionDTO {
	String sessionId;
    Integer Hints;
    Premium role;
    String Question;
    String Solution;
}
