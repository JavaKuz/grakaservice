package com.anton.grakaservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncompleteGrakaException extends Exception{
    private static final long serialVersionUID = 1L;

    public IncompleteGrakaException(String message) {
        super(message);
    }
}
