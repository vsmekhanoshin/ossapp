package com.ossapp.mainapp.repositories;

import com.ossapp.mainapp.entities.Role;
import com.ossapp.mainapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
