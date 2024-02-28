package com.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;
    @Column(name = "post_name")
    private String namePost;
    private String zipcode;
    private String address;
    @Column(name = "in_telephone")
    private String inTelephone;
    @Column(name = "out_telephone")
    private String outTelephone;
    @Column(name = "fax_number")
    private String faxNumber;
    private String sort;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "update_date")
    private Date updateDate;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "group_name")
    private Group group;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    List<User> users ;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "company_id")
//    private Company company;
//    @OneToOne
//    @JoinColumn(name = "group_name")
//    private Group group;
//
//    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
//    List<User> users =new ArrayList<>();
}
