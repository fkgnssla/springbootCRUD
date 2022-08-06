package com.khm.springbootCRUD.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int age;

    private String address;

    public void change(String name, int age, String address) {
        this.name=name;
        this.age=age;
        this.address=address;
    }
}
