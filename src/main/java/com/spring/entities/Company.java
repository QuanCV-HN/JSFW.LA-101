package com.spring.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer id;
    @Column(name = "company_name")
    private String name;
    @Column(name = "company_name_kana")
    private String kana;
    private String zipcode;
    private String address;
    private String telephone;
    @Column(name = "fax_number")
    private String fax;
    private String url;
    private String ipAddress;
    private String post;
    @Column(name = "ipaddress_internal")
    private String ipInternal;
    @Column(name = "post_internal")
    private String postInternal;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "update_date")
    private Date updateDate;

    @JsonIgnore
    @OneToMany(mappedBy = "userCompany")
    private List<User> users ;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Post> posts;

//    @OneToMany(mappedBy = "userCompany", cascade = CascadeType.ALL)
//    private List<User> users = new ArrayList<>();
//
//    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
//    private List<Post> posts = new ArrayList<>();
}
