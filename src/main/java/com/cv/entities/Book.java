package com.cv.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "price")
    private Integer price;

    public Book() {

    }

    public Book(String title, String author, Integer pages, Integer price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }
}
