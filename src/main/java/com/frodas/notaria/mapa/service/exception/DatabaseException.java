package com.frodas.notaria.mapa.service.exception;

public class DatabaseException extends RuntimeException {

    public DatabaseException() {
    }

    public DatabaseException(String exception) {
        super(exception);
    }

}
