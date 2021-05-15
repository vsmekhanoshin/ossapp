package com.ossapp.mainapp.repositories;

import com.ossapp.mainapp.entities.LevelStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelStyleRepository extends JpaRepository<LevelStyle, Long> {
}
