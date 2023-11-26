package com.barclays.LibrarySystemAPI.repository;

import com.barclays.LibrarySystemAPI.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
