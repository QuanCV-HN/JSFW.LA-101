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
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer id;
    private String name;
    private String sort;
    private Date createDate;
    private Date updateDate;

    @JsonIgnore
    @OneToMany(mappedBy = "position")
    private List<User> users ;
//
//    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
//    private List<User> users = new ArrayList<>();
}
