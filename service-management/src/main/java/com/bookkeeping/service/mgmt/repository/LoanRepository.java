package com.bookkeeping.service.mgmt.repository;

import com.bookkeeping.service.mgmt.model.LoanLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanLog, String> {
}
