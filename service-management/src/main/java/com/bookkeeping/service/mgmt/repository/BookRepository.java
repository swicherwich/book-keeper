package com.bookkeeping.service.mgmt.repository;

import com.bookkeeping.service.mgmt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
