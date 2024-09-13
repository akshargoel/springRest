package com.rest.api.project.restproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id 
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String title;
    @Column
    private  String author;
    @Column
    private String publication;
    
    
    public Book() {
    }
    
    public Book(int id, String title, String author, String publication) {
    	this.id = id;
    	this.title = title;
    	this.publication = publication;
    }

    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
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
    
    public String getPublication() {
        return publication;
    }
    
    public void setPublication(String publication) {
        this.publication = publication;
    }
    
    @Override
    public String toString() {
        return "Book [Id=" + id + ", Title=" + title + ", Author=" + author + ", Publication=" + publication + "]";
    }
    
    
}
