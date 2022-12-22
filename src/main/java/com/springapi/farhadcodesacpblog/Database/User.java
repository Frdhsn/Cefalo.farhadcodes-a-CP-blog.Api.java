package com.springapi.farhadcodesacpblog.Database;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private String password;
    private Date CreationTime = new Date(System.currentTimeMillis());
    private Date LastModifiedTime = new Date(System.currentTimeMillis());

    public Date getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(Date creationTime) {
        CreationTime = creationTime;
    }

    public Date getLastModifiedTime() {
        return LastModifiedTime;
    }

    public User(Long id, String name, String email, String password, Date creationTime, Date lastModifiedTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        CreationTime = creationTime;
        LastModifiedTime = lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        LastModifiedTime = lastModifiedTime;
    }

    public User() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", CreationTime=" + CreationTime +
                ", LastModifiedTime=" + LastModifiedTime +
                '}';
    }

}
