package br.com.estudandoemcasa.ead.authuser.controllers;

import br.com.estudandoemcasa.ead.authuser.dto.UserDto;
import br.com.estudandoemcasa.ead.authuser.enums.UserStatus;
import br.com.estudandoemcasa.ead.authuser.enums.UserType;
import br.com.estudandoemcasa.ead.authuser.models.UserModel;
import br.com.estudandoemcasa.ead.authuser.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class AuthenticatorController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> registeruSer(@RequestBody UserDto userDto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        if(userService.save(userModel)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Email Or Name are exists");
    }

}
