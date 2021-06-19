package com.ossapp.mainapp.repositories.specification;

import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.entities.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecs {
    public static Specification<User> nameCityContains(Integer beforeAge, Integer afterAge) {
        return (Specification<User>) (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.between(root.get("age"), beforeAge, afterAge);
    }

    public static Specification<User> nameCityContains(Integer partOfCityName) {
        return (Specification<User>) (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.like(root.get("name"), "%" + partOfCityName + "%");
    }
}
