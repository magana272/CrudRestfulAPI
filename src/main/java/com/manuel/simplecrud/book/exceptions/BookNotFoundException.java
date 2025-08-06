package com.manuel.simplecrud.book.exceptions;

public class BookNotFoundException extends RuntimeException {

    BookNotFoundException(Long id) {
        super("Book not found"+id);
    }
}
