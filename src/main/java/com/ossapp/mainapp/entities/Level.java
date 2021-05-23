package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "level")
public class Level extends BaseEntity {

    @Min(value = 1, message = "Минимальный уровень 1")
    @Max(value = 5, message = "Максимальный уровень 5")
    @Column(name = "value")
    private Integer value;
}
