package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "styles_tbl")
public class Style extends BaseEntity {

    @Column(name = "name_fld")
    private String name;
}
