package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "style_level")
public class StyleLevel extends BaseEntity {

    @ManyToOne
    @JoinColumn(name ="style_id")
    //TODO long
    private Style styleId;

    @ManyToOne
    @JoinColumn(name = "level_id")
    //TODO long
    private Level levelId;
}
