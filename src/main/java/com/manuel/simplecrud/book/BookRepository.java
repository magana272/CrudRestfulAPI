
package com.manuel.simplecrud.book;

import com.manuel.simplecrud.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);


    @Modifying
    @Query("update Book b set b.publishDate = ?2 where b.id = ?1")
    Book updateBookPublishDate(Long id, LocalDate publishDate);


    @Modifying
    @Query("update Book b set b.author = ?2, b.author = ?3, b.publishDate = ?4 where b.id = ?1")
    Book updateBook(Long id, String author, String title, LocalDate publishDate);







}
