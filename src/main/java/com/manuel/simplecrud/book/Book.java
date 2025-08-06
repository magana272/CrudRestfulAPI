package com.manuel.simplecrud.book;

import com.manuel.simplecrud.author.Author;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) Long k;
    private String publisher;
    @Column(insertable=true, updatable=true) private double averageRating;
    @Column(nullable = false) private LocalDate publishDate;
    private Long id;
    @NonNull private String title;
    String isbn;
    String isbn13;
    String languageCode;
    int numPages;
    int ratingsCount;
    int textReviewsCount;
    private String author;
    private String authorName;

    public Book(Long id,String authorName, String title, LocalDate date) {
        this.id = id;
        this.authorName = authorName;
        this.title = title;
        this.publishDate = date;
    }
    public Book(String authorName, String title, LocalDate date) {
        this.authorName = authorName;
        this.title = title;
        this.publishDate = date;
    }

    public Book() {}
    public Book(long bookId, String title, double averageRating, String isbn, String isbn13, String languageCode, int numPages, int ratingsCount, int textReviewsCount, LocalDate publicationDate, String publisher, long authorId) {
        this.id = bookId;
        this.title = title;
        this.publishDate = publicationDate;
        this.averageRating = averageRating;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.languageCode = languageCode;
        this.numPages = numPages;
        this.ratingsCount = ratingsCount;
        this.textReviewsCount = textReviewsCount;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return String.format("Book [id=%s, title=%s, author=%s]", id, title, authorName);
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setPublishDate(LocalDate publishDate){
        this.publishDate = publishDate;
    }
    public void setAuthor(String author){
        this.authorName = author.toLowerCase();
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return authorName;
    }
    public LocalDate getPublishDate() {
        return publishDate;
    }

}
