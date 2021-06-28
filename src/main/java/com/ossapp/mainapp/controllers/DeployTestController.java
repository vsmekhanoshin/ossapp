package com.ossapp.mainapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thisshitworksatall")
public class DeployTestController {
    @GetMapping
    public String testDeployment(){
        return "Ololo";
    }
}
