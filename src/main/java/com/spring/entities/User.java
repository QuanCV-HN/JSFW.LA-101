package com.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "turbine_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "login_name")
    private String loginName;
    @Column(name = "password_vale")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "confirm_value")
    private Integer confirm;
    private String modified;
    private String created;
    @Column(name = "last_login")
    private String lastLogin;
    private String disable;
    private String objectData;
    @Column(name = "password_changed")
    private String passwordChanged;
    @Column(name = "in_telephone")
    private String inTelephone;
    @Column(name = "out_telephone")
    private String outTelephone;
    @Column(name = "cellular_phone")
    private String cellularPhone;
    @Column(name = "cellular_mail")
    private String cellularMail;
    @Column(name = "cellular_uid")
    private String uid;
    @Column(name = "first_name_kana")
    private String firstNameKana;
    @Column(name = "last_name_kana")
    private String lastNameKana;
    private String photo;
    @Column(name = "has_photo")
    private String hasPhoto;
    @Column(name = "photo_modified")
    private String photoModified;
    @Column(name = "photo_smartphone")
    private String photoSmartphone;
    @Column(name = "has_photo_smartphone")
    private String hasPhotoSmartphone;
    @Column(name = "photo_modified_smartphone")
    private String photoModifiedSmartphone;
    @Column(name = "tutorial_forbid")
    private String tutorialForbid;
    @Column(name = "migrate_version")
    private String migrateVersion;
    @Column(name = "created_user_id")
    private Integer createId;
    @Column(name = "update_user_id")
    private Integer updateId;


    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company userCompany;

//    @OneToMany
//    private List<Post> postList ;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "position_id")
//    private Position position;
//
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "company_id")
//    private Company userCompany;
//
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private Post post;
//
//    @Column(name = "post_id",insertable = false,updatable = false)
//    private Integer postId;
}
