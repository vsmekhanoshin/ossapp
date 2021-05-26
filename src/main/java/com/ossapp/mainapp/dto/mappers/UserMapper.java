package com.ossapp.mainapp.dto.mappers;

import com.ossapp.mainapp.dto.UserDto;
import com.ossapp.mainapp.entities.User;

public class UserMapper {
    public static UserDto getDtoFromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setName(user.getName());
        userDto.setNickTelegram(user.getNickTelegram());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setWeight(user.getWeight());
        userDto.setSex(user.getSex());
        userDto.setCityName(user.getCityId().getName());
        userDto.setAbout(user.getAbout());
        userDto.setImages(user.getImages());
        userDto.setStylesLevels(user.getStylesLevels());
        return userDto;
    }
}
