package com.bookkeeping.service.mgmt.exception;

public class LoanRefusedException extends RuntimeException {

    public LoanRefusedException(String message) {
        super(message);
    }
}
