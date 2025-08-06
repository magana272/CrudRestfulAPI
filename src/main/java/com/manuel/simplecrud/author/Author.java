package com.manuel.simplecrud.author;

import com.manuel.simplecrud.book.Book;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class Author {
    @Id
//    @Column
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id") // must match mappedBy in Book
    private Book book;

    private String fullName;
    private String firstName;
    private String lastName;

    public Author(String fullName) {
       this.fullName = fullName;
    }

    public Author() {}
}
