package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "images_user")
public class UserImages extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "path")
    private String path;
}
