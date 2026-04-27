package com.rbm.artif.hint.dto;
import com.rbm.artif.hint.utilites.Premium;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class UsersDTO {
    String email;
    String username;
    String password;
    Premium premium;
}
