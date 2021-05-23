package com.ossapp.mainapp.repositories;

import com.ossapp.mainapp.entities.StyleLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleLevelRepository extends JpaRepository<StyleLevel, Long> {

    @Query(value = "select id from style_level where style_id = :1 and level_id = :2 ",
            nativeQuery = true)
    Long findByStyleIdAndLevelId(Long styleId, Long leveld);
}
