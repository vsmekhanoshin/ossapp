package com.ossapp.mainapp.repositories;

import com.ossapp.mainapp.entities.StyleLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleLevelRepository extends JpaRepository<StyleLevel, Long> {

    @Query(value = "select * from style_level where style = :styleId and level = :levelId ",
            nativeQuery = true)
    Long findByStyleIdAndLevelId(@Param("styleId") Long styleId, @Param("levelId") Long levelId);
}
