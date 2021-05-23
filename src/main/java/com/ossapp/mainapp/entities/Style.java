package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "styles")
public class Style extends BaseEntity {

    @Column(name = "value")
    @Min(value = 1, message = "Минимальное значение стиля 1")
    @Max(value = 9, message = "Максимальное значение стиля 9")
    private Integer value;
}
