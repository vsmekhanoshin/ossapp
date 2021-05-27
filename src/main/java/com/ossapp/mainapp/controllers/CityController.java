package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.dto.RequestCityDto;
import com.ossapp.mainapp.dto.ResponseCityDto;
import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.service.CityService;
import com.ossapp.mainapp.utils.CityFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<RequestCityDto> post(@RequestBody @Valid RequestCityDto requestCityDto) {
        cityService.save(requestCityDto);
        return new ResponseEntity<>(requestCityDto, HttpStatus.OK);
    }

    @GetMapping()
    public List<ResponseCityDto> getAll(@RequestParam(required = false) Map<String, String> requestParams
//            @RequestParam(value = "word", required = false) String word,
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "size", defaultValue = "9") Integer size,
//            @RequestParam(value = "sort", defaultValue = "acs") String sort
    ) {
        String cityName = null;
        if(requestParams.containsKey("name")){
            cityName = requestParams.get("name");
        }
        CityFilter cityFilter = new CityFilter(cityName);
        return cityService.findAll(cityFilter.getSpec());
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable("id") Long id) {
        return cityService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") long id) {
        return cityService.deleteById(id);
    }

    @PutMapping("/{id}")
    public RequestCityDto update(@RequestBody @Valid RequestCityDto requestCityDto, @PathVariable("id") long id) {
        cityService.update(requestCityDto, id);
        return requestCityDto;
    }
}
