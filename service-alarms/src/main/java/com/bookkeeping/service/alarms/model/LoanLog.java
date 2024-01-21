package com.bookkeeping.service.alarms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class LoanLog {

    private String id;
    private Book book;
    private LocalDate loanStartDate;
    private LocalDate loanEndDate;
    private LocalDate loanActualEndDate;
    private String details;
    private Boolean loanReturned = false;
}
