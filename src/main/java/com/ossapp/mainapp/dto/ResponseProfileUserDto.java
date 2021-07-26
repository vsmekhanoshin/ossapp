package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.entities.StyleLevel;
import com.ossapp.mainapp.entities.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResponseProfileUserDto {

    private String name;

    private String email;

    private int age;

    private String weight;

    private String sex;

    private ResponseCityDto city;

    private String about;

    private String nickTelegram;

    private List<RequestStyleLevelDto> stylesLevels;


    public ResponseProfileUserDto fromUserToResponseUserDto(User user, List<StyleLevel> styleLevelList, City city) {
        ResponseProfileUserDto responseProfileUserDto = new ResponseProfileUserDto();
        responseProfileUserDto.setName(user.getName());
        responseProfileUserDto.setEmail(user.getEmail());
        responseProfileUserDto.setNickTelegram(user.getNickTelegram());
        responseProfileUserDto.setAge(calculateAge(user.getBirthDate()));
        responseProfileUserDto.setWeight(AgeUser.getAgeUser(user.getWeight()));
        responseProfileUserDto.setSex(SexUser.getSexUser(user.getSex()));
        responseProfileUserDto.setCity(fromRequestCityToCity(city));
        //TODO вернуть string
        responseProfileUserDto.setStylesLevels(getRequestStyleLevelDtoList(styleLevelList));
        return responseProfileUserDto;
    }

    private RequestStyleLevelDto fromStyleLevelDtoToRequestStyleLevel(StyleLevel styleLevel) {
        RequestStyleLevelDto requestStyleLevelDto = new RequestStyleLevelDto();
        requestStyleLevelDto.setStyle(styleLevel.getStyle());
        requestStyleLevelDto.setLevel(styleLevel.getLevel());
        return requestStyleLevelDto;
    }

    private List<RequestStyleLevelDto> getRequestStyleLevelDtoList(List<StyleLevel> styleLevelList) {
        return styleLevelList
                .stream()
                .map(s -> fromStyleLevelDtoToRequestStyleLevel(s))
                .collect(Collectors.toList());
    }

    private ResponseCityDto fromRequestCityToCity(City city) {
        ResponseCityDto requestCityDto = new ResponseCityDto();
        requestCityDto.setName(city.getName());
        requestCityDto.setRegion(city.getRegion());
        requestCityDto.setCountry(city.getCountry());
        return requestCityDto;
    }

    private Integer calculateAge(LocalDate bthDay) {
        if (bthDay == null) {
            return null;
        }
        LocalDate currentYear = LocalDate.now();
        return Period.between(bthDay, currentYear).getYears();
    }

}
