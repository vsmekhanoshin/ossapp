package com.ossapp.mainapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @PostConstruct
    public void init() {
        System.out.println("Controller initialized");
    }
}
