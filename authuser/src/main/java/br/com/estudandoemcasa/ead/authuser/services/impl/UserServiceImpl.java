package br.com.estudandoemcasa.ead.authuser.services.impl;

import br.com.estudandoemcasa.ead.authuser.models.UserModel;
import br.com.estudandoemcasa.ead.authuser.repositories.UserRepository;
import br.com.estudandoemcasa.ead.authuser.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
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
        userRepository.deleteById(userRepository.findById(userId).orElseThrow().getUserID());
    }

    @Override
    public void save(UserModel userModel) {
        if (Boolean.FALSE.equals(userRepository.existsByEmail(userModel.getEmail())) ||
                Boolean.FALSE.equals(userRepository.existsByUserName(userModel.getUserName()))) {
            userRepository.saveAndFlush(userModel);
        }
    }

    @Transactional
    @Override
    public void update(UserModel userModel) {
        userRepository.saveAndFlush(userModel);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public Page<UserModel> findAll(Pageable pageable, Specification<UserModel> userModelSpecification) {
        return userRepository.findAll(userModelSpecification, pageable);
    }

}
