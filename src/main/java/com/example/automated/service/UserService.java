package com.example.automated.service;

import com.example.automated.model.user.User;
import com.example.automated.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<User> createUser(User user) {
        try {
            System.out.println("User: " + user);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            System.out.println("Encoded password: " + user.getPassword());

            userRepository.save(user);
            System.out.println("User saved: " + user);

            return ResponseEntity.ok(user);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();

        return ResponseEntity.ok(users);
    }
}
