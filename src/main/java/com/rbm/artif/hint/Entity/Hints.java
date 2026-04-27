package com.rbm.artif.hint.Entity;

import com.rbm.artif.hint.utilites.Premium;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Document(collection="hintsDB")
public class Hints {
    @Id
    public String email;
    public Premium premium;
    public int usage;
    @Indexed(expireAfter="0s")
    public Date closesAt;
}
