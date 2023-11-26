package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
}
