package com.ossapp.mainapp.service;

import com.ossapp.mainapp.dto.RequestUserDto;
import com.ossapp.mainapp.dto.ResponseProfileUserDto;
import com.ossapp.mainapp.dto.ResponseUserDto;
import com.ossapp.mainapp.entities.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User save(RequestUserDto requestUserDto);

    ResponseUserDto findById(Long id);

    ResponseProfileUserDto findMyProfileById(Long id);

    Long findCityIdByUserId(Long userId);

    List<ResponseUserDto> findAll(Specification<User> specification, int page, int size);
}
