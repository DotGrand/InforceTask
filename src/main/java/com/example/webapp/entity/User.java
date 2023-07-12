package com.example.webapp.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Please provide a valid first name")
    @Pattern(regexp = "[\\-a-zA-Z\\s.']+", message = "Please provide a valid first name")
    @Size(min = 2, max = 20, message = "Must not be shorter than 2 and longer than 20 characters")
    @Column(name = "user_name")
    private String userName;

    @NotNull(message = "Please provide a valid email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Please provide a valid email format")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Please provide a valid password")
    @Column(name = "password")
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

