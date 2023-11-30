package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.dto.ReserveDTO;
import com.barclays.LibrarySystemAPI.model.ReservedItem;

public interface ReserveService {
    ReservedItem save(ReserveDTO reserveDTO);
}
