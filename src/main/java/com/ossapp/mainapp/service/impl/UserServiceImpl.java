package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.dto.RequestStyleLevelDto;
import com.ossapp.mainapp.dto.RequestUserDto;
import com.ossapp.mainapp.dto.ResponseUserDto;
import com.ossapp.mainapp.entities.*;
import com.ossapp.mainapp.handkelException.CountStyleOutOfBalanceException;
import com.ossapp.mainapp.handkelException.UserNotFoundException;
import com.ossapp.mainapp.repositories.CityRepository;
import com.ossapp.mainapp.repositories.StyleLevelRepository;
import com.ossapp.mainapp.repositories.UserRepository;
import com.ossapp.mainapp.repositories.UserStyleRepository;
import com.ossapp.mainapp.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static com.ossapp.mainapp.dto.mappers.UserMapper.getDtoFromUser;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserStyleRepository userStyleRepository;
    private final StyleLevelRepository styleLevelRepository;
    private final CityRepository cityRepository;

    public UserServiceImpl(UserRepository userRepository,
                           UserStyleRepository userStyleRepository,
                           StyleLevelRepository styleLevelRepository,
                           CityRepository cityRepository) {
        this.userRepository = userRepository;
        this.userStyleRepository = userStyleRepository;
        this.styleLevelRepository = styleLevelRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public User save(RequestUserDto requestUserDto) {
        int sizeStyleList = requestUserDto.getRequestStyleLevelDtoList().size();
        if (sizeStyleList > 3) {
            throw new CountStyleOutOfBalanceException(String.format("Ошибка: в листе Юзер-Стиль больше 3 значений - %d",
                    sizeStyleList));
        }

        Optional<City> cityOpt = cityRepository.findById(requestUserDto.getCityId());
        User user = requestUserDto.fromRequestUserToUser(requestUserDto, cityOpt.get());

        requestUserDto.getRequestStyleLevelDtoList().stream()
                .forEach(u -> saveUserStyle(u, user));

        return userRepository.save(user);
    }

    private void saveUserStyle(RequestStyleLevelDto requestStyleLevelDto, User user) {
        Long styleLevelId = styleLevelRepository.findByStyleIdAndLevelId
                (requestStyleLevelDto.getStyle(), requestStyleLevelDto.getLevel());

        PkUserStyleLevelId pkUserStyleLevelId = new PkUserStyleLevelId();
        pkUserStyleLevelId.setUser_id(user.getId());
        pkUserStyleLevelId.setStyle_level_id(styleLevelId);

        UserStyle userStyle = new UserStyle();
        userStyle.setPkUserStyleLevelId(pkUserStyleLevelId);
        userStyleRepository.save(userStyle);
    }

    @Override
    public List<ResponseUserDto> findAll(Specification<User> spec, int page, int size) {
        if (page < 1L) {
            page = 0;
        }
        List<User> users = userRepository.findAll(spec, PageRequest.of(page, size)).getContent();
        List<ResponseUserDto> responseUserDtos = new ArrayList<>();
        users.forEach(u -> responseUserDtos.add(getDtoFromUser(u)));
        return responseUserDtos;
    }

    @Override
    public ResponseUserDto findById(Long id) {
        ResponseUserDto responseUserDto = getDtoFromUser(userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(String.format("Ошибка: Пользователь с id %s не найден.", id))));
        return responseUserDto;
    }

    @Override
    public Long findCityIdByUserId(Long userId) {
        return userRepository.findCityIdByUserId(userId);
    }
}