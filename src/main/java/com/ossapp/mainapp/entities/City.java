package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "cities_tbl")
public class City extends BaseEntity {

    @NotBlank (message = "Поле Город не должно быть пустым")
    @Column(name = "name_fld")
    private String name;
}
