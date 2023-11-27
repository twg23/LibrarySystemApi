package com.barclays.LibrarySystemAPI.repository;

import com.barclays.LibrarySystemAPI.model.Book;
import com.barclays.LibrarySystemAPI.model.Booking;
import com.barclays.LibrarySystemAPI.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends CrudRepository<Booking, Long> {
}
