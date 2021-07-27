package com.ossapp.mainapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum SexUser {

    MAlE("Мужской"),
    FEMALE("Женский");

    private final String sex;

    public static String getSexUser(int sexUser) {
        String sexString = MAlE.sex;

        if (sexUser == 2) {
            sexString = FEMALE.sex;
        }

        return sexString;
    }
}
