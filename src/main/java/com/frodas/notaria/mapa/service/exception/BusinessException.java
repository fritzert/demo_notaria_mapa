package com.frodas.notaria.mapa.service.exception;

public class BusinessException extends RuntimeException {

    public BusinessException() {
    }

    public BusinessException(String exception) {
        super(exception);
    }

}
