package com.manuel.simplecrud.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


interface  AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByFirstName(String firstName);

    List<Author> findByLastName(String lastName);
}
