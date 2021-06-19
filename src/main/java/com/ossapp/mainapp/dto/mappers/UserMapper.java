package com.ossapp.mainapp.dto.mappers;

import com.ossapp.mainapp.dto.ResponseUserDto;
import com.ossapp.mainapp.entities.User;
import static com.ossapp.mainapp.dto.mappers.CityMapper.*;

public class UserMapper {
    public static ResponseUserDto getDtoFromUser(User user) {
        ResponseUserDto responseUserDto = new ResponseUserDto();
//        responseUserDto.setId(user.getId());
//        responseUserDto.setEmail(user.getEmail());
//        responseUserDto.setPhone(user.getPhone());
        responseUserDto.setName(user.getName());
//        responseUserDto.setNickTelegram(user.getNickTelegram());
//        responseUserDto.setBirthDate(user.getBirthDate());
        responseUserDto.setWeight(user.getWeight());
        responseUserDto.setSex(user.getSex());
        responseUserDto.setCity(getDtoFromCity(user.getCityId()));
        responseUserDto.setAbout(user.getAbout());
        responseUserDto.setImages(user.getImages());
        responseUserDto.setStylesLevels(user.getStylesLevels());
        return responseUserDto;
    }
}
