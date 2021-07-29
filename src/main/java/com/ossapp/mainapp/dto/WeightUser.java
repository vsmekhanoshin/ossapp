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
        String weightString = null;

        if (weightUser == 1) {
            weightString = LIGHT.weight;
        } else if (weightUser == 2) {
            weightString = MIDDLE.weight;
        } else if (weightUser == 3) {
            weightString = HEAVY.weight;
        }

        return weightString;
    }
}
