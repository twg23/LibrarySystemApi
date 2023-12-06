package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.dto.ReserveDTO;
import com.barclays.LibrarySystemAPI.exception.IdNotFoundException;
import com.barclays.LibrarySystemAPI.model.*;
import com.barclays.LibrarySystemAPI.repository.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class ReserveServiceImpl implements ReserveService {

     UserRepository userRepository;
     BookRepository bookRepository;
     MovieRepository movieRepository;
     ReserveRepository reserveRepository;

     PeriodicalRepository periodicalRepository;

     ReservationStrategy reservationStrategy;


    List<Book> books= new ArrayList<>();




    @Transactional
    @Override
    public ReservedItem save (ReserveDTO reserveDTO){


        if(reserveDTO.getItemType().equals(ItemType.MOVIE)) {
            reservationStrategy =new MovieReservationStrategy();
        }

        if (reserveDTO.getItemType().equals(ItemType.MOVIE) ) {
            reservationStrategy = new BookReservationStrategy();
        }

        reservationStrategy.reserve(reserveDTO);

        User user = userRepository.findById(reserveDTO.getUserId()).

                orElseThrow(()-> new IdNotFoundException( "User ID not found exception"));

        ReservedItem reservedItem = new ReservedItem();
        reservedItem.setItemType(reserveDTO.getItemType());
        reservedItem.setDate(reserveDTO.getDate());
        reservedItem.setPeriod(7);
        reservedItem.setUser(user);

        return reserveRepository.save(reservedItem);

    }

    @Override
    public List<ReservedItem> getAllReservations() {
            List<ReservedItem> reservedItems = new ArrayList<>();
            Iterable<ReservedItem> reservedItemIts = reserveRepository.findAll();
            reservedItemIts.forEach(reservedItems::add);
            return reservedItems;
    }


    @Autowired
    public ReserveServiceImpl(UserRepository userRepository, BookRepository bookRepository, MovieRepository movieRepository, ReserveRepository reserveRepository, PeriodicalRepository periodicalRepository, ReservationStrategy reservationStrategy, List<Book> books) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.movieRepository = movieRepository;
        this.reserveRepository = reserveRepository;
        this.periodicalRepository = periodicalRepository;
        this.reservationStrategy = reservationStrategy;
        this.books = books;
    }
}

