package com.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books_user_table")
public class BookUser {

    @Id
    @Column(name = "id_user", nullable = false, unique = true)
    private Integer id_user;
    @Column(name = "ISBN_book", nullable = false, unique = true)
    private String ISBN_book;

    public BookUser(Integer id_user, String ISBN_book) {
        this.id_user = id_user;
        this.ISBN_book = ISBN_book;
    }

    public BookUser() {

    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getISBN_book() {
        return ISBN_book;
    }

    public void setISBN_book(String ISBN_book) {
        this.ISBN_book = ISBN_book;
    }
}
