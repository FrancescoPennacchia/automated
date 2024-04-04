package com.example.automated.controller;

import com.example.automated.model.user.User;
import com.example.automated.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/api/auth/register")
    public ResponseEntity<User> authenticateUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/api/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }


}
