package com.barclays.LibrarySystemAPI.controller;

import com.barclays.LibrarySystemAPI.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LibraryControllerTest {

    @Autowired
    LibraryController libraryController;

    @Test
    void findAllUsers() {
       List<User> users = libraryController.findAllUsers();
       assertEquals(3, users.size());
    }

    @Test
    void findUserById() {
        String expectedName= "Dami Bankole";
        User users = libraryController.findUserById(3l);
        assertEquals(expectedName, users.getName());
    }

    @Test
    void createUser() {

    }

    @Test
    void getUser() {
    }

    @Test
    void deleteUser() {
    }
}