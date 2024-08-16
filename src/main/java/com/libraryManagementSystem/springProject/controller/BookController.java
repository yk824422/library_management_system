package com.libraryManagementSystem.springProject.controller;

import com.libraryManagementSystem.springProject.entity.Books;
import com.libraryManagementSystem.springProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Books> getAllBooks() {
        return bookService.findAllBooks();
    }

    @PostMapping
    public Books addBook(@RequestBody Books book) {
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Optional<Books> getBookByiD(@PathVariable int id) {
        return bookService.findBookByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }


}
