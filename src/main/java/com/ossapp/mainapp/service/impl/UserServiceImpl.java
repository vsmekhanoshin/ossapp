package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.repositories.UserRepository;
import com.ossapp.mainapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}