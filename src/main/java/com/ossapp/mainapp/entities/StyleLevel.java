package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "style_level")
public class StyleLevel extends BaseEntity {

    @Column(name ="style")
    private Long style;

    @Column(name = "level_id")
    private Long level;
}
