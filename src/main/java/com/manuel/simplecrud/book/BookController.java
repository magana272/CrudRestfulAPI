package com.manuel.simplecrud.book;

import com.manuel.simplecrud.author.Author;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    Book addBook( @RequestBody Book book){
        return bookService.save(book);
    }
    @GetMapping("/books")
    List<Book> getAllBooks(){
        return bookService.findAll();
    }
    @GetMapping("/books/{id}")
    Book getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }
    @GetMapping("/books/search")
    List<Book> getBooksByAuthorName(@RequestParam Author author){
        return bookService.findAllByAuthor(author);
    }


    @PutMapping("/books/{id}")
    Book updateBookDate(@PathVariable long id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteBook(@PathVariable long id){
        bookService.deleteById(id);
    }
}