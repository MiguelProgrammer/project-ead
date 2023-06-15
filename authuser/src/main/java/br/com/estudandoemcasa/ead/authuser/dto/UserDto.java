package br.com.estudandoemcasa.ead.authuser.dto;

import br.com.estudandoemcasa.ead.authuser.dto.userutils.UserView;
import br.com.estudandoemcasa.ead.authuser.validation.UserNameConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {
    private static final long serialVersionID = 1L;

    private UUID userID;

    @Size(min = 4, max = 50, groups = UserView.RegistrationPost.class)
    @JsonView(UserView.RegistrationPost.class)
    @UserNameConstraint(groups = UserView.RegistrationPost.class)
    @NotBlank(groups = UserView.RegistrationPost.class)
    private String userName;

    @Email(groups = UserView.RegistrationPost.class)
    @JsonView(UserView.RegistrationPost.class)
    @NotBlank(groups = UserView.RegistrationPost.class)
    private String email;

    @Size(min = 6, max = 20, groups = {UserView.RegistrationPost.class, UserView.PasswordPut.class})
    @JsonView({UserView.RegistrationPost.class, UserView.PasswordPut.class})
    @NotBlank(groups = {UserView.RegistrationPost.class, UserView.PasswordPut.class})
    private String password;

    @Size(min = 6, max = 20, groups = UserView.PasswordPut.class)
    @JsonView(UserView.PasswordPut.class)
    @NotBlank(groups = UserView.PasswordPut.class)
    private String oldPassword;

    @JsonView({UserView.RegistrationPost.class,  UserView.UserPut.class})
    private String fullName;

    @JsonView({UserView.RegistrationPost.class,  UserView.UserPut.class})
    private String phoneNumber;

    @JsonView({UserView.RegistrationPost.class,  UserView.UserPut.class})
    private String cpf;

    @JsonView(UserView.ImagePut.class)
    @NotBlank(groups = UserView.ImagePut.class)
    private String imageUrl;


}
