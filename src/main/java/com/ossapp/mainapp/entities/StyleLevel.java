package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "style_level")
public class StyleLevel extends BaseEntity {

    @Column(name = "style")
    private Long style;

    @Column(name = "level")
    private Long level;

    @Column(name = "style_name")
    private String styleName;

    @Column(name = "level_name")
    private String levelName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_styles",
            joinColumns = @JoinColumn(name = "style_level_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
