package com.ossapp.mainapp.repositories.specification;

import com.ossapp.mainapp.entities.StyleLevel;
import com.ossapp.mainapp.entities.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.time.LocalDate;
import java.util.Collection;

public class UserSpecs {
    //TODO test between date
    public static Specification<User> ageBetween(Integer beforeAge, Integer afterAge) {
        final int firstDayAndMonth = 1;
        LocalDate currantDate = LocalDate.now();
        LocalDate beforeDateAge = LocalDate.of(currantDate.getYear() - beforeAge, firstDayAndMonth, firstDayAndMonth);
        LocalDate afterDateAge = LocalDate.of(currantDate.getYear() - afterAge, firstDayAndMonth, firstDayAndMonth);
        return (Specification<User>) (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.between(root.get("birthDate"), beforeDateAge, afterDateAge);
    }

    public static Specification<User> cityIdEqual(Long cityId) {
        return (Specification<User>) (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("cityId"), cityId);
    }

    public static Specification<User> sexEqual(Integer sex) {
        return (Specification<User>) (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("sex"), sex);
    }

    public static Specification<User> weightEqual(Integer weight) {
        return (Specification<User>) (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("weight"), weight);
    }

    public static Specification<User> styleEqual(Long style) {

        return (Specification<User>) (root, query, builder)
                -> {
            query.distinct(true);
            Root<User> user = root;
            Subquery<StyleLevel> styleLevelSubquery = query.subquery(StyleLevel.class);
            Root<StyleLevel> styleLevelRoot = styleLevelSubquery.from(StyleLevel.class);
            Expression<Collection<User>> usersStyle = styleLevelRoot.get("users");
            styleLevelSubquery.select(styleLevelRoot);
            styleLevelSubquery.where(builder.equal(styleLevelRoot.get("style"), style), builder.isMember(user, usersStyle));

            return builder.exists(styleLevelSubquery);
        };

    }

    public static Specification<User> levelEqual(Integer level) {
        return (Specification<User>) (root, query, builder)
                -> {
            query.distinct(true);
            Root<User> user = root;
            Subquery<StyleLevel> styleLevelSubquery = query.subquery(StyleLevel.class);
            Root<StyleLevel> styleLevelRoot = styleLevelSubquery.from(StyleLevel.class);
            Expression<Collection<User>> usersStyle = styleLevelRoot.get("users");
            styleLevelSubquery.select(styleLevelRoot);
            styleLevelSubquery.where(builder.equal(styleLevelRoot.get("level"), level), builder.isMember(user, usersStyle));

            return builder.exists(styleLevelSubquery);
        };
    }

}
