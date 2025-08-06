package com.manuel.simplecrud;

import java.sql.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.manuel.simplecrud.book.Book;
import com.manuel.simplecrud.book.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleData {


    @Bean
    CommandLineRunner initBookDataBase(BookService service) {

        LocalDate hameletDatePublished = LocalDate.parse("1999-09-02");
        LocalDate kingDatePublished = LocalDate.parse("1999-09-03");
        LocalDate manuelDatePublished = LocalDate.parse("1999-09-04");
        return args -> {
            String[] arr = {
                    "book_ID,title,average_rating,isbn,isbn13,language_code,num_pages,ratings_count,text_reviews_count,publication_date,publisher,authorid",

                    "1,Potter and the Half-Blood Prince (Harry Potter  #6),4.57,0439785960,9780439785969,eng,652,2095690,27591,9/16/2006,Scholastic Inc.,8394716670404476876",
                    "2,Harry Potter and the Order of the Phoenix (Harry Potter  #5),4.49,0439358078,9780439358071,eng,870,2153167,29221,9/1/2004,Scholastic Inc.,-1277078846803799247",
                    "4,Harry Potter and the Chamber of Secrets (Harry Potter  #2),4.42,0439554896,9780439554893,eng,352,6333,244,11/1/2003,Scholastic,8394716670404476876"
            };

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

            // Skip the header (index 0)
            for (int i = 1; i < arr.length; i++) {
                Book book = getBook(formatter, arr[i]);
                service.save(book);
            }
            service.save(new Book("William Shakespeare", "Hamlet", hameletDatePublished));
            service.save(new Book("William Shakespeare", "King Lear",kingDatePublished ));
            service.save(new Book("Manuel Magana", "Book", manuelDatePublished));

        };
    }

    private static Book getBook(DateTimeFormatter formatter, String arr) {

        System.out.println(arr);
        String[] line = arr.split(",", -1);
        long bookId = Long.parseLong(line[0]);
        String title = line[1];
        double averageRating = Double.parseDouble(line[2]);
        String isbn = line[3];
        String isbn13 = line[4];
        String languageCode = line[5];
        int numPages = Integer.parseInt(line[6]);
        int ratingsCount = Integer.parseInt(line[7]);
        int textReviewsCount = Integer.parseInt(line[8]);
        LocalDate publicationDate = LocalDate.parse(line[9], formatter);
        String publisher = line[10];
        long authorId = Long.parseLong(line[11]);


        return new Book(
                bookId,
                title,
                averageRating,
                isbn,
                isbn13,
                languageCode,
                numPages,
                ratingsCount,
                textReviewsCount,
                publicationDate,
                publisher,
                authorId
        );
    }
}