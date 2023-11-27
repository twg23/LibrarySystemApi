package com.barclays.LibrarySystemAPI.repository;

import com.barclays.LibrarySystemAPI.model.Author;
import com.barclays.LibrarySystemAPI.model.Book;
import com.barclays.LibrarySystemAPI.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT new Book (b.id, b.title, b.author,b.genre, b.isAvailable) FROM Book b WHERE b.title LIKE %:title%")
    Book searchByTitle(@Param("title") String title);

    List<Book> findAll();

    List<Book> searchByAuthorContaining(String authorName);
    List<Book> searchByGenreContains(String genre);

//    @Query("SELECT new Book (b.id, b.title, b.author,b.genre, b.isAvailable) FROM Book b WHERE b.author LIKE %:author%")
//    List<Book> searchByAuthor(@Param("author") String author);
//
//    @Query("SELECT new Book (b.id, b.title, b.author,b.genre, b.isAvailable) FROM Book b WHERE b.genre LIKE %:genre%")
//    List<Book> searchByGenre(@Param("genre") String genre);

}
