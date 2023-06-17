package br.com.estudandoemcasa.ead.authuser.services;

import br.com.estudandoemcasa.ead.authuser.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserModel> findAll();
    Optional<UserModel> findUserById(UUID userId);
    void deleteUser(UUID userId);
    void save(UserModel userModel);
    void update(UserModel userModel);
    Boolean existsByEmail(String email);
    Boolean existsByUserName(String userName);
    Page<UserModel> findAll(Pageable pageable, Specification<UserModel> userModelSpecification);
}

