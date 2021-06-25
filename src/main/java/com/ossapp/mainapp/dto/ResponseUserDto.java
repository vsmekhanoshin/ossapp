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
public class ResponseUserDto {

    private String name;

    //TODO calculate Age on bth
    private Integer age;

    private Integer weight;

    private Integer sex;

    private ResponseCityDto city;

    private String about;

//    private List<UserImages> images;

    private List<RequestStyleLevelDto> stylesLevels;


    public ResponseUserDto fromUserToResponseUserDto(User user, List<StyleLevel> styleLevelList, City city) {
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setName(user.getName());
        responseUserDto.setWeight(user.getWeight());
        responseUserDto.setSex(user.getSex());
        responseUserDto.setCity(fromRequestCityToCity(city));
        responseUserDto.setStylesLevels(getRequestStyleLevelDtoList(styleLevelList));
        responseUserDto.setAge(calculateAge(user.getBirthDate()));
        return responseUserDto;
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
