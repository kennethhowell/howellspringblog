package com.codeup.howellspringblog.model;

import javax.persistence.*;

@Entity
@Table(name="dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 20)
    private int age;

    @Column(nullable = false, length = 36)
    private String name;

    @Column(name="reside_state", nullable = false, length = 2)
    private String resideState;

    Dog(){};

    Dog(long id, int age, String name, String resideState){
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;

    }

    Dog(int age, String name, String resideState){
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }




}
