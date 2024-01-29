package com.monitoring.telemetry.controller;

import com.monitoring.telemetry.entity.User;
import com.monitoring.telemetry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.of(Optional.of(userRepository.findAll()));
    }
    @GetMapping("/service_b")
    public ResponseEntity<String> callServiceB() {
        return restTemplate.getForEntity("http://service-b:9001", String.class);
    }
}
