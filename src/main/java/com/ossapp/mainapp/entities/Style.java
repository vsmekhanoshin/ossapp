package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "level_style_tbl")
public class Style extends BaseEntity {

    @Column(name = "value")
    private Integer value;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_styles_tbl",
            joinColumns = @JoinColumn(name = "style_id"),
            inverseJoinColumns = @JoinColumn(name = "level_id"))
    private Collection<LevelStyle> styles;

}
