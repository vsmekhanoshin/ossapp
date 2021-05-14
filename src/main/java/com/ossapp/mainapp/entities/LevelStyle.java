package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "styles_tbl")
public class LevelStyle extends BaseEntity {

    @Column(name = "name_fld")
    private String name;
}
