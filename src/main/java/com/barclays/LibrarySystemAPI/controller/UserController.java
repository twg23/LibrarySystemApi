package com.barclays.LibrarySystemAPI.controller;

import com.barclays.LibrarySystemAPI.exception.TitleNotFoundException;
import com.barclays.LibrarySystemAPI.model.Book;
import com.barclays.LibrarySystemAPI.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    UserService userService;



    @GetMapping(value = "/title")
    public Book searchByTitle(@RequestParam("title") String title) {
        Book book= userService.searchByTitle(title);
        if (book == null){
            throw new TitleNotFoundException("Title not found exception");
        }
        return book;

    }

    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return userService.findAllBooks();
    }
    @GetMapping("/author")
    public List<Book> searchByAuthor(@RequestParam("name") String name){
        return userService.searchByAuthor(name);
    }


    @GetMapping("/genre")
    public List<Book> searchByGenre(@RequestParam("genre")String genre){
        return userService.searchByGenre(genre);
    }


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


}
