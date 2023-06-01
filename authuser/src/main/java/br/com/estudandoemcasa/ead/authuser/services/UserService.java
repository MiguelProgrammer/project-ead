package br.com.estudandoemcasa.ead.authuser.services;

import br.com.estudandoemcasa.ead.authuser.models.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserModel> findAll();

    Optional<UserModel> findUserById(UUID userId);
    void deleteUser(UUID userId);
}

