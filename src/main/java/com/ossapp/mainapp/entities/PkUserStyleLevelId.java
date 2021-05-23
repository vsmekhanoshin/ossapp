package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class PkUserStyleLevelId implements Serializable {

    private Long user_id;
    private Long style_level_id;
}
