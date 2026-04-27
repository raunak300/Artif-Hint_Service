package com.rbm.artif.hint.Entity;

import com.rbm.artif.hint.dto.UsersDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Document(collection="questionsDB")
public class Questions {
    @Id
    String Id;
    String sessionId;
    String count;
    String question;
    String prevSolution;
    String Topic;
    List<String> error_tags=new ArrayList<>();
    String difficulty;
}
