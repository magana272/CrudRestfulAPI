package com.manuel.simplecrud.author;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    AuthorService authorService;
    AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

}
