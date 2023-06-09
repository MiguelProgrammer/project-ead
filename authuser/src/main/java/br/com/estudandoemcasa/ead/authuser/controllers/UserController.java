package br.com.estudandoemcasa.ead.authuser.controllers;

import br.com.estudandoemcasa.ead.authuser.dto.UserDto;
import br.com.estudandoemcasa.ead.authuser.dto.userutils.UserView;
import br.com.estudandoemcasa.ead.authuser.models.UserModel;
import br.com.estudandoemcasa.ead.authuser.services.UserService;
import br.com.estudandoemcasa.ead.authuser.specifications.SpecificationTemplate;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static br.com.estudandoemcasa.ead.authuser.constants.Constants.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    private HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    @GetMapping
    public ResponseEntity<Page<UserModel>> getAllUsers(
            SpecificationTemplate.UserSpec userSpec, @PageableDefault(sort = "userID", direction = Sort.Direction.ASC)
                                                       Pageable pageable){
        Page<UserModel> userModels = userService.findAll(pageable, userSpec);
        userModels.stream().filter(userModel -> !Objects.isNull(userModel))
                .forEach(us -> us.add(linkTo(methodOn(UserController.class).getOneUser(us.getUserID())).withSelfRel()));
        return ResponseEntity.status(HttpStatus.OK).body(userModels);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getOneUser(@PathVariable("userId") UUID userId){
        Optional<UserModel> userModelOptional = userService.findUserById(userId);
        return userModelOptional.isEmpty()?
                ResponseEntity.status(httpStatus).body(USER_NOT_FOUND)
                : ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object>  deleteUser(@PathVariable("userId") UUID userId){
        if(Objects.isNull(getOneUser(userId))) {
            return ResponseEntity.status(httpStatus).body(USER_NOT_FOUND);
        } else{
            httpStatus = HttpStatus.OK;
            userService.deleteUser(userId);
            return ResponseEntity.status(httpStatus).body(USER_UPDATE);
        }
    }

    @Transactional
    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable("userId") UUID userId,
                                             @RequestBody @Validated(UserView.UserPut.class)
                                             @JsonView(UserView.UserPut.class) UserDto userDto) {

        log.info("Method: UPDATE USER\n");

        Optional<UserModel> userModelOptional = userService.findUserById(userId);
        StringBuilder message = new StringBuilder(USER_OR_PASSWORD_INCORRECT);

        if(userModelOptional.isPresent() && this.haveAccess(userDto, userModelOptional)){
            userModelOptional.get().setFullName(userDto.getFullName());
            userModelOptional.get().setPhoneNumber(userDto.getPhoneNumber());
            userModelOptional.get().setCpf(userDto.getCpf());
            userModelOptional.get().setLastUpdateDate(LOCAL_DATE_TIME_NOW);

            httpStatus = HttpStatus.OK;
            message.delete(0, message.length());
            message.insert(0, USER_UPDATE);
        }

        return ResponseEntity.status(httpStatus).body(message);
    }

    @Transactional
    @PutMapping("/{userId}/password")
    public ResponseEntity<Object> updatePassword(@PathVariable("userId") UUID userId,
                                                 @RequestBody
                                                 @Validated({UserView.PasswordPut.class,UserView.RegistrationPost.class})
                                                 @JsonView(UserView.PasswordPut.class) UserDto userDto){

        log.info("Method: UPDATE PASSWORD\n");

        Optional<UserModel> userModelOptional = userService.findUserById(userId);
        StringBuilder message = new StringBuilder(USER_OR_PASSWORD_INCORRECT);

        if(userModelOptional.isPresent() && userDto.getOldPassword().equals(userModelOptional.get().getPassword())){
            userModelOptional.get().setPassword(userDto.getPassword());
            userModelOptional.get().setLastUpdateDate(LOCAL_DATE_TIME_NOW);

            httpStatus = HttpStatus.OK;
            message.delete(0, message.length());
            message.insert(0, PASSWORD_UPDATE);
            userService.update(userModelOptional.get());
        }

        return ResponseEntity.status(httpStatus).body(message);
    }

    @Transactional
    @PutMapping("/{userId}/image")
    public ResponseEntity<Object> updateImg(@PathVariable("userId") UUID userId,
                                            @RequestBody
                                            @Validated(UserView.ImagePut.class)
                                            @JsonView(UserView.ImagePut.class) UserDto userDto){

        log.info("Method: UPDATE IMG\n");

        Optional<UserModel> userModelOptional = userService.findUserById(userId);
        StringBuilder message = new StringBuilder(USER_OR_PASSWORD_INCORRECT);

        if(userModelOptional.isPresent()){
            userModelOptional.get().setImageUrl(userDto.getImageUrl());
            userModelOptional.get().setLastUpdateDate(LOCAL_DATE_TIME_NOW);

            httpStatus = HttpStatus.OK;
            message.delete(0, message.length());
            message.insert(0, IMG_UPDATE);
        }

        return ResponseEntity.status(httpStatus).body(message);
    }

    private Boolean haveAccess(UserDto userDto, Optional<UserModel> userModelOptional) {
        return userModelOptional.orElseThrow().getPassword().equals(userDto.getPassword());
    }
}
