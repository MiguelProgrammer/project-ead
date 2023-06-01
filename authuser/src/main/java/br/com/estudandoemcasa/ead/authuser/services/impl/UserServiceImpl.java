package br.com.estudandoemcasa.ead.authuser.services.impl;

import br.com.estudandoemcasa.ead.authuser.models.UserModel;
import br.com.estudandoemcasa.ead.authuser.repositories.UserRepository;
import br.com.estudandoemcasa.ead.authuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> findAll() {
        return Optional.of(userRepository.findAll()).orElse(null);
    }

    @Override
    public Optional<UserModel> findUserById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userRepository.findById(userId).get().getUserID());
    }
}
