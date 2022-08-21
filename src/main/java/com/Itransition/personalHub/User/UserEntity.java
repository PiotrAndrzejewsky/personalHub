package com.Itransition.personalHub.User;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long mId;

    @Column(name = "username")
    private String mUsername;

    @Column(name = "password")
    private String mPassword;

    @Column(name = "active")
    private boolean mActive = true;

    @Column(name = "admin")
    private Boolean mAdmin = false;

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    public Long getId() {
        return mId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public boolean isActive() {
        return mActive;
    }

    public void setActive(boolean active) {
        mActive = active;
    }

    public Boolean getAdmin() {
        return mAdmin;
    }

    public void setAdmin(Boolean admin) {
        mAdmin = admin;
    }
}

