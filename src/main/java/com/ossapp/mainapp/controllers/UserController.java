package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.entities.dto.UserDto;
import com.ossapp.mainapp.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String get(){
        return "Ololo";
    }
    @PostMapping
    public ResponseEntity<User> post(@RequestBody UserDto userDto) {
        User registered = userService.save(userDto);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered));
        return new ResponseEntity<>(registered, HttpStatus.OK);
    }

}
