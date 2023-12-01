package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.dto.ReserveDTO;
import com.barclays.LibrarySystemAPI.exception.IdNotFoundException;
import com.barclays.LibrarySystemAPI.exception.ItemNotFoundException;
import com.barclays.LibrarySystemAPI.model.*;
import com.barclays.LibrarySystemAPI.repository.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    List<Book> books= new ArrayList<>();




    @Transactional
    @Override
    public ReservedItem save (ReserveDTO reserveDTO){


        if(reserveDTO.getTitle().equals("MOVIE")) {
            List<Movie> movies = movieRepository.searchByTitle(reserveDTO.getTitle());
            if (movies.isEmpty()) throw new ItemNotFoundException("Item not found");

            if (!(movies.get(0).getQuantity()>0)){
                throw new ResponseStatusException(HttpStatusCode.valueOf(422),"Item not available");
            }
            else {
                movies.get(0).setQuantity((movies.get(0).getQuantity())-1);
                movieRepository.save(movies.get(0));
            }
        }

        if (reserveDTO.getTitle().equals("BOOK") ) {

            List<Book> books = bookRepository.findByTitle(reserveDTO.getTitle());


            if (books.isEmpty()) {

                throw new ItemNotFoundException("Item not found");
            }

            log.debug("books quantity"  + books.get(0).getQuantity());

            if (!(books.get(0).getQuantity()>0)){

                throw new ResponseStatusException(HttpStatusCode.valueOf(422),"Item not available");
            }
            else {
                books.get(0).setQuantity((books.get(0).getQuantity())-1);

                bookRepository.save(books.get(0));
            }
        }
        if (reserveDTO.getTitle().equals("PERIODICAL")) {
            List<Periodical> periodicals= periodicalRepository.searchByTitle(reserveDTO.getTitle());
            if (periodicals.isEmpty()) throw new ItemNotFoundException("Item not found");
        }

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
    public ReserveServiceImpl( UserRepository userRepository, BookRepository bookRepository, MovieRepository movieRepository, ReserveRepository reserveRepository, PeriodicalRepository periodicalRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.movieRepository = movieRepository;
        this.reserveRepository = reserveRepository;
        this.periodicalRepository = periodicalRepository;
    }

    }

