package com.ossapp.mainapp.utils;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.repositories.specification.UserSpecs;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

@Getter
public class UserFilter {
    private Specification<User> spec;

    public UserFilter(Integer ageBefore, Integer ageAfter, Long cityId, Long style, Integer level, Integer sex, Integer weight) {
        this.spec = Specification.where(null);

        if (ageBefore != null || ageAfter != null) {
            spec = spec.and(UserSpecs.ageBetween(ageBefore, ageAfter));
        }

        if (style != null) {
            spec = spec.and(UserSpecs.styleEqual(style));
        }

        if (level != null) {
            spec = spec.and(UserSpecs.levelEqual(level));
        }

        if (cityId != null) {
            spec = spec.and(UserSpecs.cityIdEqual(cityId));
        }

        if (sex != null) {
            spec = spec.and(UserSpecs.sexEqual(sex));
        }

        if (weight != null) {
            spec = spec.and(UserSpecs.weightEqual(weight));
        }

    }
}
