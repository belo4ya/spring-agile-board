package com.example.agileboard.controllers;

import com.example.agileboard.dto.user.UserDto;
import com.example.agileboard.exceptions.ResourceNotFoundException;
import com.example.agileboard.models.User;
import com.example.agileboard.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }

    @PostMapping("/auth/signIn")
    public UserDto signIn(@RequestBody User user) {
        System.out.println(user.getName());
        User authUser = userRepository.findByName(user.getName()).orElseThrow(ResourceNotFoundException::new);
        return new UserDto(authUser);
    }
}
