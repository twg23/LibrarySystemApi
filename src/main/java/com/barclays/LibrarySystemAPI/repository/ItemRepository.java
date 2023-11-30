package com.barclays.LibrarySystemAPI.repository;

import com.barclays.LibrarySystemAPI.model.Genre;
import com.barclays.LibrarySystemAPI.model.Item;
import com.barclays.LibrarySystemAPI.model.ItemType;
import com.barclays.LibrarySystemAPI.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {

    Item findByItemTypeAndItemTitle(ItemType itemType, String itemTitle);
}
