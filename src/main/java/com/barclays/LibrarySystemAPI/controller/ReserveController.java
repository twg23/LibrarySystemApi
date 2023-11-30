package com.barclays.LibrarySystemAPI.controller;

import com.barclays.LibrarySystemAPI.dto.ReserveDTO;
import com.barclays.LibrarySystemAPI.model.ReservedItem;
import com.barclays.LibrarySystemAPI.model.User;
import com.barclays.LibrarySystemAPI.service.ReserveService;
import com.barclays.LibrarySystemAPI.service.ReserveServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ReserveController {
    private ReserveService reserveService;

    @PostMapping("/reserve")
    public ReservedItem reserveItem(@RequestBody  ReserveDTO  reserveDTO){
        log.debug(String.valueOf(reserveDTO));
        return reserveService.save( reserveDTO);
       // return  null;
    }

    @Autowired
    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }
}
