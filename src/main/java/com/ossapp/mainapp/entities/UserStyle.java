//package com.ossapp.mainapp.entities;
//
//import lombok.Data;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.time.LocalDateTime;
//
//@Data
//@Entity
//@Table(name = "user_styles_tbl")
//public class UserStyle {
//
//    @EmbeddedId
//    private UserStylePK userStyleId;
//
//    @ManyToOne()
//    @NotNull(message = "Уровень мастерства не выбран")
//    @JoinColumn(name = "level_id")
//    private LevelStyle levelStyle;
//
//    @Column(name = "create_at")
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @Column(name = "update_at")
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;
//}
