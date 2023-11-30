package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.dto.ReserveDTO;
import com.barclays.LibrarySystemAPI.dto.UserRequestDTO;
import com.barclays.LibrarySystemAPI.exception.IdNotFoundException;
import com.barclays.LibrarySystemAPI.exception.ItemNotFoundException;
import com.barclays.LibrarySystemAPI.model.*;
import com.barclays.LibrarySystemAPI.repository.BookRepository;
import com.barclays.LibrarySystemAPI.repository.ItemRepository;
import com.barclays.LibrarySystemAPI.repository.ReserveRepository;
import com.barclays.LibrarySystemAPI.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReserveServiceImpl implements ReserveService {

     ItemRepository itemRepository;
     UserRepository userRepository;
     BookRepository bookRepository;
     ReserveRepository reserveRepository;
    @Override
    public ReservedItem save(ReserveDTO reserveDTO){

       /* my method should take  json paylod from the user that matched the reserve dto .
       based on this information i should be able make a reservation and save this to the database,
        the id the user provides should match  a. registered id on the database
         if not throw a id not found exception
*/

        Item item =  itemRepository.findByItemTypeAndItemTitle(
                reserveDTO.getItemType(),
                reserveDTO.getTitle());
        if (item == null) {
            throw  new ItemNotFoundException("Item not found: " + reserveDTO.getItemType() +  reserveDTO.getTitle());
        }




        User user = userRepository.findById(reserveDTO.getId()).
                orElseThrow(()-> new IdNotFoundException( "User ID not found exception"));

      // Book book= (Book) bookRepository.findByTitleContainingIgnoreCase(item.getItemTitle());

        ReservedItem reservedItem = new ReservedItem();
        reservedItem.setItemType(item.getItemType());
        reservedItem.setItem(item);
        reservedItem.setDate(reserveDTO.getDate());
        reservedItem.setPeriod(7);
        reservedItem.setId(user.getId());

        return reserveRepository.save(reservedItem);


    }

    @Autowired
    public ReserveServiceImpl(ItemRepository itemRepository, UserRepository userRepository, BookRepository bookRepository, ReserveRepository reserveRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.reserveRepository = reserveRepository;
    }
}
