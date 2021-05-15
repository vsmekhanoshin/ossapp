package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.City;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestCityDto {
    @NotBlank
    private String name;

    public City fromRequestCityToCity(RequestCityDto requestCityDto) {
        City city = new City();
        city.setName(requestCityDto.getName());
        return city;
    }
}
