package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.dto.RequestUserDto;
import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userservice;

    public UserController(UserService userService) {
        this.userservice = userService;
    }

    @GetMapping
    public List<User> getAllUsers(@RequestParam(required = false) Map<String, String> requestParams) {
        int pageNumber = Integer.parseInt(requestParams.getOrDefault("page", "0"));
        return userService.findAll(pageNumber);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RequestUserDto> post(@RequestBody @Valid RequestUserDto requestUserDto) {
        userservice.save(requestUserDto);
        return new ResponseEntity<>(requestUserDto, HttpStatus.OK);
    }

}
