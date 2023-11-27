package com.barclays.LibrarySystemAPI.controller;

import com.barclays.LibrarySystemAPI.exception.IdNotFoundException;
import com.barclays.LibrarySystemAPI.model.User;
import com.barclays.LibrarySystemAPI.repository.UserRepository;
import com.barclays.LibrarySystemAPI.service.LibraryService;
import com.barclays.LibrarySystemAPI.service.UserService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class LibraryController {

    private LibraryService libraryService;
    private UserRepository userRepository;

    @Autowired
    public LibraryController(LibraryService libraryService, UserRepository userRepository) {
        this.libraryService = libraryService;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/user")
    public List<User> findAllUsers(){
       return libraryService.findAllUsers();
    }

    @GetMapping( "/user/{id}")
    public User findUserById(@PathVariable  Long id){
       return libraryService.findUserById(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
       return libraryService.save(user);
    }

    @GetMapping(value = "user/search")
    public List<User> getUser(@PathParam("name") String name) {
        List<User> user = Collections.emptyList();
        if(StringUtils.isNotBlank(name)) {
            user = libraryService.searchByName(name);

        }
        else {
            user = libraryService.findAllUsers();
        }

        return user;
    }


    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id){
        libraryService.deleteUser(id);

    }







}
