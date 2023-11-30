package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.dto.ReserveDTO;
import com.barclays.LibrarySystemAPI.dto.UserRequestDTO;
import com.barclays.LibrarySystemAPI.model.*;
import com.barclays.LibrarySystemAPI.repository.BookRepository;
import com.barclays.LibrarySystemAPI.repository.ItemRepository;
import com.barclays.LibrarySystemAPI.repository.ReserveRepository;
import com.barclays.LibrarySystemAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
//public class ReserveServiceImpl {
//     ItemRepository itemRepository;
//     UserRepository userRepository;
//     BookRepository bookRepository;
//     ReserveRepository reserveRepository;
//    public User save(ReserveDTO reserveDTO){
//
//        Item item = new Item();
//            item=    itemRepository.findByItemTypeAndItemTitle(
//                ItemType.valueOf(reserveDTO.getItemType()),
//                reserveDTO.getTitle());
//
//
//        User user = new  User();
//        user.setId(reserveDTO.getId());
//        userRepository.findById(reserveDTO.getId());
//
//      // Book book= (Book) bookRepository.findByTitleContainingIgnoreCase(item.getItemTitle());
//
//        ReservedItem reservedItem = new ReservedItem();
//        reservedItem.setItemType(item.getItemType());
//        reservedItem.setItem(item);
//        reservedItem.setDate(reserveDTO.getDate());
//        reservedItem.setPeriod(7);
//        reservedItem.setId(user.getId());
//
//        return reserveRepository.save(reservedItem);
//
//
//    }
//
//    @Autowired
//    public ReserveServiceImpl(ItemRepository itemRepository, UserRepository userRepository, BookRepository bookRepository, ReserveRepository reserveRepository) {
//        this.itemRepository = itemRepository;
//        this.userRepository = userRepository;
//        this.bookRepository = bookRepository;
//        this.reserveRepository = reserveRepository;
//    }
//}
