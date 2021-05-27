package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.dto.RequestCityDto;
import com.ossapp.mainapp.dto.ResponseCityDto;
import com.ossapp.mainapp.dto.mappers.CityMapper;
import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.repositories.CityRepository;
import com.ossapp.mainapp.service.CityService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City save(RequestCityDto requestCityDto) {
        return cityRepository.save(requestCityDto.fromRequestCityToCity(requestCityDto));
    }

    @Override
    public Long deleteById(Long id) {
        cityRepository.deleteById(id);
        return id;
    }

    @Override
    public City update(RequestCityDto requestCityDto, long id) {
        Optional<City> styleOptional = cityRepository.findById(id);
        styleOptional.get().setName(requestCityDto.getName());
        return cityRepository.save(styleOptional.get());
    }

    @Override
    public List<ResponseCityDto> findAll(Specification<City> spec) {
        List<City> cities = cityRepository.findAll(spec);
        List<ResponseCityDto> responseCityDtos = new ArrayList<>();
        cities.forEach(c -> responseCityDtos.add(CityMapper.getDtoFromCity(c)));
        return responseCityDtos;
    }
}
