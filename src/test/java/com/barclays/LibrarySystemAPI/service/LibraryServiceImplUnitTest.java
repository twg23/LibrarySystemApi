package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.model.*;
import com.barclays.LibrarySystemAPI.repository.BookRepository;
import com.barclays.LibrarySystemAPI.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LibraryServiceImplUnitTest {
    private User user;
    @InjectMocks
    private LibraryServiceImpl libraryService;
    @MockBean
    private UserRepository userRepository;
    List<User> userList;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Address address = new Address(1L,"43 Jenson street", "Nottingham", "NG6 5TY","UK");
        Address address2 = new Address(2L,"65 Broadson street", "Nottingham", "NG8 9TY","UK");




        userList=  new ArrayList<>();
        userList.add(new User(1L, "Tolu Adetomiwa",address,"07347284950", "toluadetomiwa@gmail.com" ));
        userList.add(new User(2L, "Tise Oludayomi",address2,"07347583840", "tiseoludayomi@gmail.com" ));

    }


    @Test
    void findAllUsers() {
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        List<User> userList1= libraryService.findAllUsers();
        assertEquals(userList1.size(), userList.size());
    }

//    @Test
//    void findUserById() {
//        Mockito.when(userRepository.findById(1L)).thenReturn(user.getId());
//        User user= libraryService.findUserById(1L);
//        assertEquals(userList1.size(), userList.size());
//
//    }

    @Test
    void save() {
        User user5= new User(4L,"Dara Gbenle", new Address(3L,"34 Mascara street", "Nottingham", "NG4 8BE","UK"),"07852946702","daragbenle@gmail.com");

        Mockito.when(userRepository.save(user5)).thenReturn(user5);
        User user3= libraryService.save(user5);
        assertEquals(user3,user5);

    }

//    @Test
//    void deleteUser() {
//        Mockito.when(userRepository.findById(2L)).thenReturn(user.getId(2L));
//        Mockito.when(userRepository.deleteById(2L));
//        libraryService.deleteUser(2L);
//
//
//    }

    @Test
    void searchByName() {
    }
}