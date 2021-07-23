package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.entities.VerificationToken;
import com.ossapp.mainapp.repositories.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

@Service
@AllArgsConstructor
public class VerificationTokenService {
    private static final int EXPIRATION = 60 * 24;
    private VerificationTokenRepository repository;

    public void createToken(User user, String token) {
        VerificationToken myToken = new VerificationToken();
        myToken.setToken(token);
        myToken.setUser(user);
        myToken.setExpiryDate(calculateExpiration());
        repository.save(myToken);
    }

    private Date calculateExpiration() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(calendar.getTime().getTime()));
        calendar.add(Calendar.MINUTE, EXPIRATION);
        return new Date(calendar.getTime().getTime());
    }

    public VerificationToken getTokenFromDB(String token) {
        return repository.findByToken(token);
    }
}
