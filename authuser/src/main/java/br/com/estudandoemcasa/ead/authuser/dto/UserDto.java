package br.com.estudandoemcasa.ead.authuser.dto;

import br.com.estudandoemcasa.ead.authuser.dto.userutils.UserView;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {
    private static final long serialVersionID = 1L;

    private UUID userID;

    @JsonView(UserView.RegistrationPost.class)
    private String userName;

    @JsonView(UserView.RegistrationPost.class)
    private String email;

    @JsonView({UserView.RegistrationPost.class, UserView.PasswordPut.class})
    private String password;

    @JsonView(UserView.PasswordPut.class)
    private String oldPassword;

    @JsonView({UserView.RegistrationPost.class,  UserView.UserPut.class})
    private String fullName;

    @JsonView({UserView.RegistrationPost.class,  UserView.UserPut.class})
    private String phoneNumber;

    @JsonView({UserView.RegistrationPost.class,  UserView.UserPut.class})
    private String cpf;

    @JsonView(UserView.ImagePut.class)
    private String imageUrl;


}
