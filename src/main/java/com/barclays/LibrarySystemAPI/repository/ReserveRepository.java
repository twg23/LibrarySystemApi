package com.barclays.LibrarySystemAPI.repository;

import com.barclays.LibrarySystemAPI.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ReserveRepository extends CrudRepository<Item,Long> {
}
