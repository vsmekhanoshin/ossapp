package com.ossapp.mainapp.utils;

import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.repositories.specification.CitySpecs;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

@Getter
public class CityFilter {
    private Specification<City> spec;

    public CityFilter(String cityName) {
        this.spec = Specification.where(null);
//        Проверку на null сделал здесь, а не в контроллере, на случай если будем делать ещё 100500 фильтров.
        if (cityName != null) {
            spec = spec.and(CitySpecs.nameCityContains(cityName));
        }
    }
}
