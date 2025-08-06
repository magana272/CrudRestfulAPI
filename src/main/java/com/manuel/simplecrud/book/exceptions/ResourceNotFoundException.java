package com.manuel.simplecrud.book.exceptions;


public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
}
