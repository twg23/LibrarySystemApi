package com.barclays.LibrarySystemAPI.service;


import com.barclays.LibrarySystemAPI.exception.IdNotFoundException;
import com.barclays.LibrarySystemAPI.model.User;
import com.barclays.LibrarySystemAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {


    private UserRepository userRepository;


   @Override
   public List<User> findAllUsers(){
      List<User> users = new ArrayList<>();
      userRepository.findAll().forEach(users ::add);
      return users;
   }

   @Override
   public User findUserById(Long id){
      Optional<User> user= userRepository.findById(id);
      return user.orElseThrow(()->new IdNotFoundException("Id not found "));
   }


   @Override
   public User save(User user){
      return userRepository.save(user);
   }

   @Override
   public void deleteUser(Long id){

     User user = userRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Id not found"));
       userRepository.deleteById(user.getId());

   }


   @Override
   public List<User> searchByName(String name){
      return userRepository.searchByName(name);
   }






    @Autowired
    public LibraryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
