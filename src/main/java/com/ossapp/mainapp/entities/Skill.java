package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "skills_tbl")
public class Skill extends BaseEntity {

    @Min(value = 1, message = "Минимальный уровень 1")
    @Max(value = 5, message = "Максимальный уровень 5")
    @Column(name = "value_fld")
    private Integer value;
}
