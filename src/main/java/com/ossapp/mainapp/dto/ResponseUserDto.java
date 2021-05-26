package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.entities.StyleLevel;
import com.ossapp.mainapp.entities.UserImages;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class ResponseUserDto {
    private Long id;

    private String email;

    private String phone;

    private String name;

    private String nickTelegram;

    private Date birthDate;

    private Integer weight;

    private Integer sex;

    private ResponseCityDto city;

    private String about;

    private List<UserImages> images;

    private Collection<StyleLevel> stylesLevels;
}
