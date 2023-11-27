package com.barclays.LibrarySystemAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class TitleNotFoundException extends RuntimeException {
        public TitleNotFoundException(String message){
            super(message);
        }
    }

