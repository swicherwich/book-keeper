package com.bookkeeping.service.mgmt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "loan_log")
@Getter
@Setter
@NoArgsConstructor
public class LoanLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(targetEntity = Book.class)
    private Book book;

    @Column(name = "loan_start_date", nullable = false)
    private LocalDate loanStartDate;

    @Column(name = "loan_end_date", nullable = false)
    private LocalDate loanEndDate;

    @Column(name = "loan_actual_end_date")
    private LocalDate loanActualEndDate;

    @Column(name = "details", nullable = false)
    private String details;

    @Column(name = "loan_returned", nullable = false)
    private Boolean loanReturned = false;
}
