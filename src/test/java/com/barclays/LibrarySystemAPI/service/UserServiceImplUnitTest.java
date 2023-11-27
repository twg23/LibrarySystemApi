package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.model.Author;
import com.barclays.LibrarySystemAPI.model.Book;
import com.barclays.LibrarySystemAPI.model.Genre;
import com.barclays.LibrarySystemAPI.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplUnitTest {


    private Book book;
    @InjectMocks
    private UserServiceImpl userService;
    @MockBean
    private BookRepository bookRepository;
    List<Book> bookList;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
       Author author= new Author("Wole Soyinka");
       Author author1 = new Author("Tolani Shoneye");

       Genre genre= new Genre(1L,"Fiction");
       Genre genre2= new Genre(2L,"Children");
       Genre genre3= new Genre(3L,"Thriller");


        bookList=  new ArrayList<>();
        bookList.add(new Book(1L, "Mary had a little lamb",author , genre,true ));
        bookList.add(new Book(2L, "Blah Blah sheep" , author1 , genre2,true));
        bookList.add(new Book(3L, "Upon the old solid rock" ,author, genre3,true));

    }


    @Test
    void searchByTitle() {
        Mockito.when(bookRepository.searchByTitle("Blah Blah sheep")).thenReturn(bookList.get(2));
        Book book1 = userService.searchByTitle("Blah Blah sheep");
        assertEquals(book1,bookList.get(2) );

    }

    @Test
    void findAllBooks() {
        Mockito.when(bookRepository.findAll()).thenReturn(bookList);
        List<Book> bookList1= userService.findAllBooks();
        assertEquals(bookList1.size(), bookList.size());
    }
    @Test
    void searchByAuthor() {
        List<Book> actualList = bookList.stream()
                .filter(book -> "Wole".equals(book.getAuthor()))
                .collect(Collectors.toList());

        when(bookRepository.searchByAuthorContaining("Wole")).thenReturn(
                bookList.stream().filter(book ->{ //booklist usins stream api to filter through the booklist to get every book wole has written
                    //sending back as a list
                    return book.getAuthor().equals("Wole");
                }).collect(Collectors.toList()));
        List<Book> expectedList= userService.searchByAuthor("Wole");
        assertEquals(actualList, expectedList);
    }

    @Test
    void searchByGenre() {
    }
}