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
        public List<ReservedItem> getAllReservations(){
            List <ReservedItem> reservedItems= new ArrayList<>();
            Iterable<ReservedItem>reservedItemIts = reserveRepository.findAll();
            reservedItemIts.forEach(reservedItems::add);
            return reservedItems;
        }
//    @Transactional
//    @Override
//    public ReservedItem save (ReserveDTO reserveDTO){
//
//
//
//        if(reserveDTO.getTitle().equals("MOVIE")) {
//            List<Movie> movies = movieRepository.searchByTitle(reserveDTO.getTitle());
//            if (movies.isEmpty()) throw new ItemNotFoundException("Item not found");
//
//            if (!(movies.get(0).getQuantity()>0)){
//                throw new ResponseStatusException(HttpStatusCode.valueOf(422),"Item not available");
//            }
//            else {
//                movies.get(0).setQuantity((movies.get(0).getQuantity())-1);
//                movieRepository.save(movies.get(0));
//            }
//        }
//
//        if (reserveDTO.getTitle().equals("BOOK") ) {
//            log.debug("Inside BOOK reservation logic");
//
//
//            List<Book> books = bookRepository.findByTitleContainingIgnoreCase(reserveDTO.getTitle());
//
//            log.debug("get title " + reserveDTO.getTitle());
//
//            log.debug("get book " + books);
//
//            if (books.isEmpty()) {
//
//                log.debug("No books found");
//
//                throw new ItemNotFoundException("Item not found");
//            }
//
//            log.debug("books quantity"  + books.get(0).getQuantity());
//
//            if (!(books.get(0).getQuantity()>0)){
//
//                log.debug("Books not available");
//
//                throw new ResponseStatusException(HttpStatusCode.valueOf(422),"Item not available");
//            }
//            else {
//                books.get(0).setQuantity((books.get(0).getQuantity())-1);
//
//                log.debug(" new book  quatity" + books.get(0).getQuantity());
//
//                bookRepository.save(books.get(0));
//            }
//        }
//        if (reserveDTO.getTitle().equals("PERIODICAL")) {
//            List<Periodical> periodicals= periodicalRepository.searchByTitle(reserveDTO.getTitle());
//            if (periodicals.isEmpty()) throw new ItemNotFoundException("Item not found");
//        }
//
//        User user = userRepository.findById(reserveDTO.getUserId()).
//
//                orElseThrow(()-> new IdNotFoundException( "User ID not found exception"));
//
//        ReservedItem reservedItem = new ReservedItem();
//        reservedItem.setItemType(reserveDTO.getItemType());
//        reservedItem.setDate(reserveDTO.getDate());
//        reservedItem.setPeriod(7);
//        reservedItem.setUser(user);
//        log.debug(String.valueOf(reservedItem.getId()));
//
//
//        log.debug("Before save - books.get(0).getQuantity(): " + books.get(0).getQuantity());
//
//        return reserveRepository.save(reservedItem);
//
//        // log.debug("After save - books.get(0).getQuantity(): " + books.get(0).getQuantity());
//
//
//    }


//    @Transactional
//    @Override
//    public ReservedItem save (ReserveDTO reserveDTO){
//
//
//
//        if(reserveDTO.getTitle().equals("MOVIE")) {
//            List<Movie> movies = movieRepository.searchByTitle(reserveDTO.getTitle());
//            if (movies.isEmpty()) throw new ItemNotFoundException("Item not found");
//
//            if (!(movies.get(0).getQuantity()>0)){
//                throw new ResponseStatusException(HttpStatusCode.valueOf(422),"Item not available");
//            }
//            else {
//                movies.get(0).setQuantity((movies.get(0).getQuantity())-1);
//                movieRepository.save(movies.get(0));
//            }
//        }
//
//        if (reserveDTO.getItemType().equals(ItemType.BOOK) ) {
//            log.debug("Inside BOOK reservation logic");
//
//
//            books = bookRepository.findByTitle(reserveDTO.getTitle());
//
//
//
//            if (books.isEmpty()) {
//
//                log.debug("No books found");
//
//                throw new ItemNotFoundException("Item not found");
//            }
//
//            log.debug("books quantity"  + books.get(0).getQuantity());
//
//            if (!(books.get(0).getQuantity()>0)){
//
//                log.debug("Books not available");
//
//                throw new ResponseStatusException(HttpStatusCode.valueOf(422),"Item not available");
//            }
//            else {
//                books.get(0).setQuantity((books.get(0).getQuantity())-1);
//
//                log.debug(" new book  quatity" + books.get(0).getQuantity());
//
//                bookRepository.save(books.get(0));
//            }
//        }
//
//        if (reserveDTO.getTitle().equals("PERIODICAL")) {
//            List<Periodical> periodicals= periodicalRepository.searchByTitle(reserveDTO.getTitle());
//            if (periodicals.isEmpty()) throw new ItemNotFoundException("Item not found");
//        }
//
//        User user = userRepository.findById(reserveDTO.getUserId()).
//
//                orElseThrow(()-> new IdNotFoundException( "User ID not found exception"));
//
//        ReservedItem reservedItem = new ReservedItem();
//        reservedItem.setItemType(reserveDTO.getItemType());
//        reservedItem.setDate(reserveDTO.getDate());
//        reservedItem.setPeriod(7);
//        reservedItem.setUser(user);
//        log.debug(String.valueOf(reservedItem.getId()));
//
//
//        log.debug("Before save - books.get(0).getQuantity(): " + books.get(0).getQuantity());
//
//        return reserveRepository.save(reservedItem);
//
//
//

   // }




    @Autowired
    public ReserveServiceImpl( UserRepository userRepository, BookRepository bookRepository, MovieRepository movieRepository, ReserveRepository reserveRepository, PeriodicalRepository periodicalRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.movieRepository = movieRepository;
        this.reserveRepository = reserveRepository;
        this.periodicalRepository = periodicalRepository;
    }

    }

