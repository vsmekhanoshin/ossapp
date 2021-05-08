package com.ossapp.mainapp.controllers;

import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class UserController {
    @PostConstruct
    public void init(){
        System.out.println("Controller initialized");
    }
}
