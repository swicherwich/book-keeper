package com.bookkeeping.service.mgmt.exception.handler;

import jakarta.annotation.Priority;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.core.Ordered.LOWEST_PRECEDENCE;

@ControllerAdvice
@Priority(LOWEST_PRECEDENCE)
public class DefaultApplicationExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ProblemDetails> handle(Throwable e) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetails);
    }

}
