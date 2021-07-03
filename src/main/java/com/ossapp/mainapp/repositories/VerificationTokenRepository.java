package com.ossapp.mainapp.repositories;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
}
