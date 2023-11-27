package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.dto.BookResponse;
import com.barclays.LibrarySystemAPI.model.Book;
import com.barclays.LibrarySystemAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    /**
     * - search by author
     * search by title
     * search by genre
     */


    private BookRepository bookRepository;
    @Override
    public BookResponse searchByTitle(String title){
        BookResponse response = new BookResponse();
        Book book= bookRepository.searchByTitle(title);
        response.setTitle(book.getTitle());
        response.setId(book.getId());
        response.setGenre(book.getGenre());
        response.setAuthor(List.of(book.getAuthor()));
        response.setAvailable(book.isAvailable());

        return response;
   }


//    public Book searchByTitle(String title){
//        BookResponse response = new BookResponse();
//        return bookRepository.searchByTitle(title);
//    }

    @Override
    public List<Book> findAllBooks(){
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().forEach(bookList :: add);
        return bookList;
      //  return bookRepository.findAll();
    }


    @Override
    public List<Book> searchByAuthor(String authorName){
        return bookRepository.searchByAuthorContaining(authorName);
    }

    @Override
    public List<Book> searchByGenre(String genre){
        return bookRepository.searchByGenreContains(genre);
    }





    @Autowired
    public UserServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
