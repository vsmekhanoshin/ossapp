package com.ossapp.mainapp.service;

import com.ossapp.mainapp.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findById(Long id);

    List<User> findAll();
}
