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
    public Book searchByTitle(String title){
        return bookRepository.searchByTitle(title);
   }



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
