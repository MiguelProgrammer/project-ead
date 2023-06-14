package br.com.estudandoemcasa.ead.authuser.services;

import br.com.estudandoemcasa.ead.authuser.models.UserModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserModel> findAll();
    Optional<UserModel> findUserById(UUID userId);
    void deleteUser(UUID userId);
    Boolean save(UserModel userModel);
    UserModel update(UserModel userModel);
    Boolean existsByEmail(String email);
    Boolean existsByUserName(String userName);
}

