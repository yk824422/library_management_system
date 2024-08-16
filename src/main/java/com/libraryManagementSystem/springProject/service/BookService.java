package com.libraryManagementSystem.springProject.service;


import com.libraryManagementSystem.springProject.entity.Books;
import com.libraryManagementSystem.springProject.entity.Users;
import com.libraryManagementSystem.springProject.repository.BookRepository;
import com.libraryManagementSystem.springProject.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private usersRepository userRepository;

    public Books addBook(Books book){
        return bookRepository.save(book);
    }
    public List<Books> findAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Books> findBookByID(Integer iD){
        return  bookRepository.findById(iD);
    }

    public void deleteBook(int bookId){
          bookRepository.deleteById(bookId);
    }

}
