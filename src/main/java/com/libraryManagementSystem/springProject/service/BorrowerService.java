package com.libraryManagementSystem.springProject.service;

import com.libraryManagementSystem.springProject.entity.Books;
import com.libraryManagementSystem.springProject.entity.Borrowers;
import com.libraryManagementSystem.springProject.entity.Users;
import com.libraryManagementSystem.springProject.repository.BorrowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {
    @Autowired
    private BorrowersRepository borrowersRepository;

    public void save(Borrowers borrowers){
        borrowersRepository.save(borrowers);
    }
    public  Borrowers findByUserIdBookId (Integer booksId, Long userId){
       return borrowersRepository.findByUserIdAndBookId(userId,booksId);
    }
    public void delete(Borrowers borrowers){
        borrowersRepository.delete(borrowers);
    }
}
