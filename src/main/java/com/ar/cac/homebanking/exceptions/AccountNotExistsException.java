package com.ar.cac.homebanking.exceptions;

public class AccountNotExistsException extends RuntimeException {
    public AccountNotExistsException(String message) {
        super(message);
    }
}
