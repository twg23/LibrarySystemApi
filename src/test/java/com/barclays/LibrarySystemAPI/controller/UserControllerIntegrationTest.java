package com.barclays.LibrarySystemAPI.controller;

import com.barclays.LibrarySystemAPI.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerIntegrationTest {
    @Autowired
    UserController userController;

//    @Test
//    void searchByTitle() {
//        List<Book> books = userController.searchByTitle("Mirror");
//        assertEquals("Mirror Mirror", books.get(3).getTitle());
//    }

    @Test
    void findAllBooks() {
        List<Book> books = userController.findAllBooks();
        assertEquals(4, books.size());
    }

    @Test
    void searchByAuthor() {
        List<Book> author = userController.searchByAuthor("Wole");
        assertEquals("Wole",author.get(1).getAuthor().getName());
    }

    @Test
    void searchByGenre() {
    }
}