package com.libraryManagementSystem.springProject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "borrower")
@NoArgsConstructor
@Data
public class Borrowers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    public Long userId;

    @Column(name = "book_id")
    public  int bookId;

    public Borrowers(Long userId, int bookId) {
        this.userId= userId;
        this.bookId = bookId;
    }
}
