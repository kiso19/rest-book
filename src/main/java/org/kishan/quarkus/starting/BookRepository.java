package org.kishan.quarkus.starting;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(new Book(1, "Understanding quarkus", "Autonio", 2020, genre),
        new Book(2, "Practing Quarkus", "Antonio", 2020, genre),
        new Book(3, "Efective Java", "Josh Bloch", 2021, genre),
        new Book(4, "Thinking in Java", "Bruce Eckel", 1998, genre));
    }


    public Optional<Book> getBook(int id){
        return getAllBooks().stream().filter(book -> book.getId() == id).findFirst();
    }
}
