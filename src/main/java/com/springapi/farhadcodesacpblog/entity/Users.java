package com.springapi.farhadcodesacpblog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @NotEmpty
    @NotNull
    @Pattern(regexp = "^[A-Za-z\\s]+$"  , message = "Invalid name. name must have length atleast 3 character UpperCase or LowerCase")
    private String name;
    @NotBlank
    @NotEmpty
    @NotNull
    @Column(unique = true)
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email have to be unique")
    private String email;
    @NotBlank
    @NotEmpty
    @NotNull
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date CreationTime = new Date(System.currentTimeMillis());

    public Users(int id, String name, String email, String password, Date creationTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        CreationTime = creationTime;
    }

    public Users() {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", CreationTime=" + CreationTime +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users user = (Users) o;
        return id == user.id && name.equals(user.name) && email.equals(user.email) && password.equals(user.password) && CreationTime.equals(user.CreationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
