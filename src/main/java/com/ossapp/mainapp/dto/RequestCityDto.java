package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.City;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestCityDto {
    @NotBlank
    private String name;

    @NotBlank
    private String region;

    @NotBlank
    private String country;

    public City fromRequestCityToCity(RequestCityDto requestCityDto) {
        City city = new City();
        city.setName(requestCityDto.getName());
        city.setRegion(requestCityDto.getRegion());
        city.setCountry(requestCityDto.getCountry());
        return city;
    }
}
