package com.corporateclient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClientAlreadyExit extends RuntimeException {

    public ClientAlreadyExit(String message) {
        super(message);
    }

}