package com.ossapp.mainapp.dto.mappers;

import com.ossapp.mainapp.dto.ResponseCityDto;
import com.ossapp.mainapp.entities.City;

public class CityMapper {
    public static ResponseCityDto getDtoFromCity(City city) {
        ResponseCityDto responseCityDto = new ResponseCityDto();
//        responseCityDto.setId(city.getId());
        responseCityDto.setName(city.getName());
        responseCityDto.setRegion(city.getRegion());
        responseCityDto.setCountry(city.getCountry());
        return responseCityDto;
    }
}
