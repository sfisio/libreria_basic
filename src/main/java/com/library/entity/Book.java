package com.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books_table")
public class Book {

    @Id
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
    @Column(name = "Title", nullable = false, length = 100)
    private String title;
    @Column(name = "Author", nullable = false, length = 100)
    private String author;
    @Column(name = "ISBN", unique = true, nullable = false, length = 18)
    private String isbn;
    @Column(name = "Time_added", nullable = false)
    private String time_added;
    @Column(name = "Time_removed", nullable = true)
    private String time_removed;
    @Column(name = "Plot", nullable = false, length = 1000)
    private String plot;
    @Column(name = "Num_readings", nullable = false)
    private int num_readings;

    public Book(Integer id, String title, String author, String isbn, String time_added, String time_removed, String plot, int num_readings) {
    	this.id=id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.time_added = time_added;
        this.time_removed = time_removed;
        this.plot = plot;
        this.num_readings = num_readings;
    }

    public Book() {

    }
    

    public Integer getId() {
    	return id;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTime_added() {
        return time_added;
    }

    public void setTime_added(String time_added) {
        this.time_added = time_added;
    }

    public String getTime_removed() {
        return time_removed;
    }

    public void setTime_removed(String time_removed) {
        this.time_removed = time_removed;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getNum_readings() {
        return num_readings;
    }

    public void setNum_readings(int num_readings) {
        this.num_readings = num_readings;
    }
    
}
