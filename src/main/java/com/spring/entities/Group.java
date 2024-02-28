package com.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "turbine_group")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer id;
    @Column(name = "group_name")
    private String name;
    private String objectData;
    @Column(name = "owner_id")
    private Integer ownerId;
    @Column(name = "group_alias_name")
    private String alias;
    @Column(name = "public_flag")
    private String flag;

    @JsonIgnore
    @OneToOne(mappedBy = "group")
    private Post post;

//    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
//    private Post post;

}
