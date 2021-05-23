package com.ossapp.mainapp.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Data
@Embeddable
public class PkUserStyleLevelId implements Serializable {

    private Long userId;
    private Long styleLevelId;
}
