package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.model.User;
import com.barclays.LibrarySystemAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


   private UserRepository userRepository;

   @Override
   public List<User> findAllUsers(){
      List<User> users = new ArrayList<>();
      userRepository.findAll().forEach(users ::add);
      return users;
   }

   @Autowired
   public UserServiceImpl(UserRepository userRepository) {
      this.userRepository = userRepository;
   }
}
