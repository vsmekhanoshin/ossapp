package com.ossapp.mainapp.service;

import com.ossapp.mainapp.dto.RequestCityDto;
import com.ossapp.mainapp.dto.ResponseCityDto;
import com.ossapp.mainapp.entities.City;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    City findById(Long id);

    City save(RequestCityDto requestCityDto);

    Long deleteById(Long id);

    City update(RequestCityDto requestCityDto, long id);

    List<ResponseCityDto> findAll(Specification<City> spec, int page);
}
