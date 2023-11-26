package com.barclays.LibrarySystemAPI.controller;

import com.barclays.LibrarySystemAPI.model.User;
import com.barclays.LibrarySystemAPI.repository.UserRepository;
import com.barclays.LibrarySystemAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UsersController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/user")
    public List<User> findAllUsers(){
       return userService.findAllUsers();
    }
}
