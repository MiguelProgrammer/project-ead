package br.com.estudandoemcasa.ead.authuser.dto;

import br.com.estudandoemcasa.ead.authuser.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {
    private static final long serialVersionID = 1L;

    private UUID userID;
    private String userName;
    private String email;
    private String password;
    private String oldPassword;
    private String fullName;
    private String phoneNumber;
    private String cpf;
    private String imageUrl;
}
