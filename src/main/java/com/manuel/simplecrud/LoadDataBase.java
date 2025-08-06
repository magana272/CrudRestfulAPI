package com.manuel.simplecrud;

import com.manuel.simplecrud.book.Book;
import com.manuel.simplecrud.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import java.time.LocalDate;

@Configuration
public class LoadDataBase {

    private static final Logger logger = LoggerFactory.getLogger(LoadDataBase.class);

    LocalDate hameletDatePublished = LocalDate.parse("1999-09-02");
    LocalDate kingDatePublished = LocalDate.parse("1999-09-03");
    LocalDate manuelDatePublished = LocalDate.parse("1999-09-04");


    @Bean
    CommandLineRunner initDatabase(BookService service) {
        return args -> {


        };
    }
}
