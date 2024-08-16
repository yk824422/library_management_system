package com.libraryManagementSystem.springProject.repository;

import com.libraryManagementSystem.springProject.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {
}
