package com.ossapp.mainapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@NoArgsConstructor
@Data
@Table(name = "verification_tokens")
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "id")
    private User user;

    @Column(name = "expiry_date")
    private Date expiryDate;

    public VerificationToken(String token, User user) {
        this.token = token;
        this.user = user;
    }
}


