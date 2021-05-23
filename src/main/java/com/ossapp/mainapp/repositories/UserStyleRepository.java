package com.ossapp.mainapp.repositories;

import com.ossapp.mainapp.entities.PkUserStyleLevelId;
import com.ossapp.mainapp.entities.UserStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStyleRepository extends JpaRepository<UserStyle, PkUserStyleLevelId> {
}
