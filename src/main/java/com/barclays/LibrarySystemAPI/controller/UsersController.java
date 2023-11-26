package com.barclays.LibrarySystemAPI.controller;

import com.barclays.LibrarySystemAPI.exception.IdNotFoundException;
import com.barclays.LibrarySystemAPI.model.User;
import com.barclays.LibrarySystemAPI.repository.UserRepository;
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

    @GetMapping( "/user/{id}")
    public User findUserById(@PathVariable  Long id){
       return userService.findUserById(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
       return userService.save(user);
    }

    @GetMapping(value = "/user/name")
    public List<User> getUser(@PathParam("name") String name) {
        List<User> user = Collections.emptyList();
        if(StringUtils.isNotBlank(name)) {
            user = userService.searchByName(name);

        }
        else {
            user = userService.findAllUsers();
        }

        return user;
    }


    @DeleteMapping("delete/{id}")
    public void deleteUser(Long id){
       userService.deleteUser(id);

    }





}
