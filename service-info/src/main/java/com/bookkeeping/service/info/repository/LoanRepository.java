package com.bookkeeping.service.info.repository;

import com.bookkeeping.service.info.model.LoanLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanLog, String> {
}
