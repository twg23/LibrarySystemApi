package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.dto.BookResponse;
import com.barclays.LibrarySystemAPI.model.Book;

import java.util.List;

public interface UserService {
   // Book searchByTitle(String title);
    BookResponse searchByTitle(String title);

    List<Book> findAllBooks();

    List<Book> searchByAuthor(String authorName);

    List<Book> searchByGenre(String genre);
}
