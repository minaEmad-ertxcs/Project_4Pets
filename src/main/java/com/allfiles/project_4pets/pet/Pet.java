package com.allfiles.project_4pets.pet;

import com.allfiles.project_4pets.user.User;

import javax.persistence.*;

@Entity
@Table(name = "Pet")
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

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    public Pet() {
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBreed() {
        return breed;
    }

    public void setBreed(int breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
