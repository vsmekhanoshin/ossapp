package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class UserStylePK implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "style_id")
    private Long styleId;
}
