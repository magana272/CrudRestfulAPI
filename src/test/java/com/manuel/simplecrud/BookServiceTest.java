package com.manuel.simplecrud;

import com.manuel.simplecrud.book.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class BookServiceTest {
    Book book;

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService(bookRepository);
        book = new Book("Sarah J. Maas", "A Court of A Court of Thorns and Roses", LocalDate.parse("1999-08-14"));
        book.setId(1L);
    }

    @Test
    void shouldCreateBook() {

        when(bookRepository.save(book)).thenReturn(book);
        Book savedBook = bookService.createBook(book);
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getAuthor()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("A Court of A Court of Thorns and Roses");
    }
//    @Test
//    void ShouldUpdateBook() {
//        LocalDate desiredchange = LocalDate.parse("1999-09-02");
//        when(bookRepository.save(book)).thenReturn(book);
//        Book savedBook  = bookService.createBook(book);
//        when(bookRepository.updateBookPublishDate(book.getId(),
//                desiredchange)).
//                thenAnswer(invocationOnMock ->  {
//                    book.setPublishDate(desiredchange);
//                    return book;
//                });
//
//        Book updatedbook = bookService.updateDatePublished(savedBook.getId(),
//                desiredchange);
//        assertThat(updatedbook.getPublishDate()).isEqualTo(LocalDate.parse("1999-09-02"));
//    }
}
