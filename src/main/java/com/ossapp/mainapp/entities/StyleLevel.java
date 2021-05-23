package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "style_level")
public class StyleLevel extends BaseEntity {

    @ManyToOne
    @JoinColumn(name ="style_id")
    private Style styleId;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level levelId;
}
