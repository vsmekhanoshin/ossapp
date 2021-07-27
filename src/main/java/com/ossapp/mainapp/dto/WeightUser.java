package com.ossapp.mainapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum WeightUser {

    LIGHT("Легкий"),
    MIDDLE("Средний"),
    HEAVY("Тяжелый");

    private final String weight;

    public static String getAgeUser(int weightUser) {
        String weightString = MIDDLE.weight;

        if (weightUser < 70) {
            weightString = LIGHT.weight;
        } else if (weightUser > 85) {
            weightString = HEAVY.weight;
        }

        return weightString;
    }
}
