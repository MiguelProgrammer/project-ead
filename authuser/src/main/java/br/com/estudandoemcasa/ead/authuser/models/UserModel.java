package br.com.estudandoemcasa.ead.authuser.models;

import br.com.estudandoemcasa.ead.authuser.enums.UserStatus;
import br.com.estudandoemcasa.ead.authuser.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_USERS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel implements Serializable {
    private static final long serialVersionID = 1L;

    public UserModel() {
        this.userStatus = UserStatus.ACTIVE;
        this.userType = UserType.STUDENT;
        this.creationDate = LocalDateTime.now(ZoneId.of("UTC"));
        this.lastUpdateDate = LocalDateTime.now(ZoneId.of("UTC"));
    }

    public UserModel(UUID userID, String userName, String email, String password, String fullName, UserStatus userStatus, UserType userType, String phoneNumber, String cpf, String imageUrl, LocalDateTime creationDate, LocalDateTime lastUpdateDate) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.userStatus = UserStatus.ACTIVE;
        this.userType = UserType.STUDENT;
        this.phoneNumber = phoneNumber;
        this.cpf = cpf;
        this.imageUrl = imageUrl;
        this.creationDate = LocalDateTime.now(ZoneId.of("UTC"));
        this.lastUpdateDate = LocalDateTime.now(ZoneId.of("UTC"));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userID;

    @Column(nullable = false, unique = true, length = 50)
    private String userName;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @JsonIgnore
    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 150)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus userStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 20)
    private String cpf;

    @Column
    private String imageUrl;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime lastUpdateDate;
}
