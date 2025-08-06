package com.manuel.simplecrud.book;

import com.manuel.simplecrud.author.Author;
import com.manuel.simplecrud.book.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public List<Book> findAllByAuthor(Author author) {
        return bookRepository.findByAuthor(author.toString());
    }

    public Book updateDatePublished(Long id, LocalDate datePublished) {
            Book book = bookRepository.findById(id).orElse(null);
            if (book != null) {
                return bookRepository.updateBookPublishDate(id, datePublished);
            }else{
                throw new ResourceNotFoundException("Book with id " + id + " not found");
            }
    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }


    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
    public Book updateBook(Long id, Book book){
        if(bookRepository.existsById(id)) {
           return bookRepository.updateBook(id, book.getAuthor(),  book.getTitle(), book.getPublishDate());
        }
        throw new ResourceNotFoundException("Book with id " + id + " not found");

    }

}
