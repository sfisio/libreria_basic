package com.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "users_table")
public class User {

    @Column(name = "email")
    private String email;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "surname", nullable = false, length = 100)
    private String surname;
    @Id
    @Column(name = "id_user", nullable = false, unique = true)
    private Integer id_user;
    @Column(name = "password", nullable = false)
    private String password;

    public User(String email, String name, String surname, int id_user, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.id_user = id_user;
        this.password = password;
    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
