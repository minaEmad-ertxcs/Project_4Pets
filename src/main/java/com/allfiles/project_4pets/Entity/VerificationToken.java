package com.allfiles.project_4pets.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="verification_token")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="token")
    private String Token;

    @Column(name="expiry_date")
    private Timestamp expiry_date;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public VerificationToken() {
    }


    public VerificationToken(String token, User user) {
        Token = token;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Timestamp getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Timestamp expiry_date) {
        this.expiry_date = expiry_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
