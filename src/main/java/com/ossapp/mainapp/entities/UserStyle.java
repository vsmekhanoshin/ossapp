package com.ossapp.mainapp.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_styles_tbl")
public class UserStyle {

    @EmbeddedId
    private UserStylePK userStyleId;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
