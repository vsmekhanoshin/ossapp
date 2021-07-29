package com.ossapp.mainapp.repositories.specification;

import com.ossapp.mainapp.entities.City;
import org.springframework.data.jpa.domain.Specification;

public class CitySpecs {
    public static Specification<City> nameCityContains(String partOfCityName) {
        return (Specification<City>) (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.like(root.get("name"), "%" + partOfCityName + "%");
    }
}
