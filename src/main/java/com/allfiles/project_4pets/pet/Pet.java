package com.allfiles.project_4pets.pet;

import javax.persistence.*;

@Entity
@Table(name="Pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "type")
    private String type;
    @Column(nullable = false, name = "age")
    private int age;
    @Column(nullable = false, name = "breed")
    private int breed;
    @Column(nullable = false, name = "gender")
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", breed=" + breed +
                ", gender='" + gender + '\'' +
                '}';
    }

}
