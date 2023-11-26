package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User findUserById(Long id);

    User save(User user);

    void deleteUser(Long id);

    List<User> searchByName(String name);
}
