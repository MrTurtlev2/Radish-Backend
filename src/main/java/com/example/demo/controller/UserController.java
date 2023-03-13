package com.example.demo.controller;

import com.example.demo.dto.PrincipalDto;
import com.example.demo.dto.UserCredentialsDto;
import com.example.demo.entity.User;
import com.example.demo.repository.PlantRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all-users")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping(value = "/userLogin")
    public PrincipalDto logIn(@RequestBody UserCredentialsDto userCredentialsDto) {
        return userService.logIn(userCredentialsDto);
    }
}
