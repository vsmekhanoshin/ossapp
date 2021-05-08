package com.ossapp.mainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunApplication {
	public static void main(String[] args) {
		System.out.println("Hello world");
		SpringApplication.run(RunApplication.class, args);
	}
}
