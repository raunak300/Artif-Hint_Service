package com.rbm.artif.hint.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@RequiredArgsConstructor
@Document(collection = "sessionDB")
public class Session {
    public String sessionId;
    @Id
    public String email;
    public boolean isActive;
}
