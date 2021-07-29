package com.ossapp.mainapp.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

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

    //TODO test LocalDate
    @Column(name = "birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @NotNull
    private LocalDate birthDate;

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
    
    @OneToOne(targetEntity = VerificationToken.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private VerificationToken verificationToken;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "enabled")
    private boolean enabled;

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
    public User() {
//        super();
        this.enabled=false;
    }
}
