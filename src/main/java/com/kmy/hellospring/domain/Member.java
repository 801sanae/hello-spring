package com.kmy.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id //pk설정.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 생성해주는거
    private Long id;

//    @Column(name= "username")
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
