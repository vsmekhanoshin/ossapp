package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_images_tbl")
public class UserImages extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;

    @Column(name = "path_fld")
    private String path;
}
