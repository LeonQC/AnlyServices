package com.angusF.Anly.controller;

import com.angusF.Anly.model.NewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private UserDetailsManager jdbcManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody NewUser newUser) {
        ResponseEntity<String> response;
        try {
            if (jdbcManager.userExists(newUser.getUsername())) {
                throw new Exception("Username is used! Please use another username!");
            }
            String hashPassword = passwordEncoder.encode(newUser.getPassword());
            UserDetails user = User.withUsername(newUser.getUsername()).password(hashPassword).roles("user").build();
            jdbcManager.createUser(user);
            response = ResponseEntity.status(HttpStatus.CREATED)
                    .body("New user is successfully registered");
        } catch (Exception e) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred: " + e.getMessage());
        }
        return response;
    }
}
