package com.springapi.farhadcodesacpblog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String password;
    private Date CreationTime = new Date(System.currentTimeMillis());
    private Date LastModifiedTime = new Date(System.currentTimeMillis());

    public User(int id, String name, String email, String password, Date creationTime, Date lastModifiedTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        CreationTime = creationTime;
        LastModifiedTime = lastModifiedTime;
    }


    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(Date creationTime) {
        CreationTime = creationTime;
    }

    public Date getLastModifiedTime() {
        return LastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        LastModifiedTime = lastModifiedTime;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && name.equals(user.name) && email.equals(user.email) && password.equals(user.password) && CreationTime.equals(user.CreationTime) && LastModifiedTime.equals(user.LastModifiedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
