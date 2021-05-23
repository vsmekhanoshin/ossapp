package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    @NotBlank (message = "Поле Город не должно быть пустым")
    @Column(name = "name")
    private String name;

    @NotBlank (message = "Поле Регион не должно быть пустым")
    @Column(name = "region")
    private String region;

    @NotBlank (message = "Поле Страна не должно быть пустым")
    @Column(name = "country")
    private String country;
}
