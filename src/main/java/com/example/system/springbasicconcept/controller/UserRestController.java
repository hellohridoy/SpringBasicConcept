package com.example.system.springbasicconcept.controller;

import com.example.system.springbasicconcept.DTO.CreateUserDTO;
import com.example.system.springbasicconcept.entity.User;
import com.example.system.springbasicconcept.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/api/v1/user/create-user")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO createUserDTO){
        User savedUser = userService.createUser(createUserDTO);
       return ResponseEntity.ok(savedUser);
    }
}
