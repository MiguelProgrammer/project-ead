package br.com.estudandoemcasa.ead.authuser.controllers;

import br.com.estudandoemcasa.ead.authuser.models.UserModel;
import br.com.estudandoemcasa.ead.authuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getOneUser(@PathVariable("userId") UUID userId){
        Optional<UserModel> userModelOptional = userService.findUserById(userId);
        return userModelOptional.isEmpty()?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found.")
        : ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
    }

    @DeleteMapping
    public ResponseEntity<Object>  deleteUser(@PathVariable("userId") UUID userId){
        if(Objects.isNull(getOneUser(userId))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found.");
        } else{
            userService.deleteUser(userId);
            return ResponseEntity.status(HttpStatus.OK).body("User Deleted Success");
        }
    }
}
