package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userservice;

    @Autowired
    public UserController(UserService userService) {
        this.userservice = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userservice.findAll();
    }
}
