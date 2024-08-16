package com.libraryManagementSystem.springProject.repository;

import com.libraryManagementSystem.springProject.entity.Borrowers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowersRepository extends JpaRepository<Borrowers,Integer> {
    // Custom query to find a Borrower by userId and bookId
    Borrowers findByUserIdAndBookId(Long userId, Integer bookId);
}
