package com.ossapp.mainapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    @Pattern(regexp = "^((\\+7)+([0-9]){10})$")
    private String phone;

    @Column(name = "name")
    private String name;

    @Column(name = "nick_telegram")
    private String nickTelegram;

    @Column(name = "birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    @NotNull
    private Date birthDate;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "sex")
    private Integer sex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City cityId;

    @Column(name = "about")
    private String about;

    @OneToMany(mappedBy = "userId", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<UserImages> images;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_styles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "style_level_id"))
    private List<StyleLevel> stylesLevels;

//    public void addImage(UserImages userImages) {
//        if (userImages == null) {
//            images = new ArrayList<>();
//        }
//        images.add(userImages);
//    }
}
