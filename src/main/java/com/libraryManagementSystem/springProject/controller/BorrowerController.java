package com.libraryManagementSystem.springProject.controller;

import com.libraryManagementSystem.springProject.entity.Books;
import com.libraryManagementSystem.springProject.entity.Borrowers;
import com.libraryManagementSystem.springProject.entity.Users;
import com.libraryManagementSystem.springProject.repository.BorrowersRepository;
import com.libraryManagementSystem.springProject.service.BookService;
import com.libraryManagementSystem.springProject.service.BorrowerService;
import com.libraryManagementSystem.springProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/borrowers")
public class BorrowerController {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowerService borrowerService;

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(@RequestParam Long userId, @RequestParam int bookId) {
        Books book = bookService.findBookByID(bookId).orElse(null);
        Users user = userService.findUserByID(userId).orElse(null);
        if(book !=null && user != null){
            Boolean availability = book.getAvailable();
            if(!availability){
                return new ResponseEntity<>("Book already borrowed by user", HttpStatus.BAD_REQUEST);
            }
            Borrowers borrower = new Borrowers(userId, bookId);
            borrowerService.save(borrower);
            book.setAvailable(false);
            bookService.addBook(book);
            return new ResponseEntity<>("Book borrowed successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to borrow book: ", HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/return")
    public ResponseEntity<String> returnBook(@RequestParam Integer userId, @RequestParam Long bookId) {
        Borrowers borrowers = borrowerService.findByUserIdBookId(userId,bookId);
        if(borrowers == null){
           return new ResponseEntity<>( "Borrower record not found", HttpStatus.BAD_REQUEST);
        }

        // Delete the borrower record
        borrowerService.delete(borrowers);

        // Update the book's availability status
        var book = bookService.findBookByID(bookId.intValue()).orElse(null);
       if(book != null){
           book.setAvailable(true);
       }

        bookService.addBook(book);

        return new ResponseEntity<>("Book returned successfully", HttpStatus.OK);
    }
}
