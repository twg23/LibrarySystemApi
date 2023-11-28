package com.barclays.LibrarySystemAPI.controller;

import com.barclays.LibrarySystemAPI.exception.TitleNotFoundException;
import com.barclays.LibrarySystemAPI.model.Book;
import com.barclays.LibrarySystemAPI.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    UserService userService;



//    @GetMapping(value = "/title")
//    public Book searchByTitle(@RequestParam("title") String title) {
//        List<Book> books = Collections.emptyList();
//        if(StringUtils.isNotBlank(title)) {
//            books =userService.searchByTitle(title);
//        }
//        else {
//           books= userService.findAllBooks();
//        }
//
//        return books;
//    }




    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return userService.findAllBooks();
    }
    @GetMapping("/author")
    public List<Book> searchByAuthor(@RequestParam("name") String authorName){
        return userService.searchByAuthor(authorName);
    }


    @GetMapping("/genre")
    public List<Book> searchByGenre(String genre){
        return userService.searchByGenre(genre);
    }


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


}
