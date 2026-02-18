package com.onur.stockguard.domain.exception;

public class ReservationExpiredException extends DomainException {

    public ReservationExpiredException(String message) {
        super(message);
    }
}
