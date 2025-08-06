package com.manuel.simplecrud.author;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    public Author save(Author author) {
        return authorRepository.save(author);
    }
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }
    public void delete(Author author) {
        authorRepository.delete(author);
    }
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
    public List<Author> findByFirstName(String name) {
        return authorRepository.findByFirstName(name);
    }
    public List<Author> findByLastName(String name) {
        return authorRepository.findByLastName(name);
    }

}
