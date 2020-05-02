package book;

import book.model.Book;
import com.github.javafaker.Faker;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class BookGenerator {


    public static Book generatebook(){
        Book book = new Book();
        Faker f = new Faker();

        Date date = f.date().birthday();
        LocalDate pubDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        book.setAuthor(f.name().fullName());
        book.setAvailable(f.bool().bool());
        book.setFormat(f.options().option(Book.Format.class));
        book.setPages(f.number().numberBetween(10,1000));
        book.setPublicationDate(pubDate);
        book.setPublisher(f.book().publisher());
        book.setTitle(f.book().title());
        book.setIsbn13(f.code().isbn13());
    return book;
    }



}
