package com.bookkeeping.service.mgmt.exception.handler;

import com.bookkeeping.service.mgmt.exception.BookNotFoundException;
import com.bookkeeping.service.mgmt.exception.BookUnavailableException;
import com.bookkeeping.service.mgmt.exception.LoanRefusedException;
import jakarta.annotation.Priority;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@ControllerAdvice
@Priority(HIGHEST_PRECEDENCE)
public class ApplicationExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ProblemDetails> handle(BookNotFoundException e) {
        return createResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoanRefusedException.class)
    public ResponseEntity<ProblemDetails> handle(LoanRefusedException e) {
        return createResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookUnavailableException.class)
    public ResponseEntity<ProblemDetails> handle(BookUnavailableException e) {
        return createResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ProblemDetails> createResponse(String message, HttpStatus statusCode) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(message);
        return ResponseEntity.status(statusCode).body(problemDetails);
    }
}
