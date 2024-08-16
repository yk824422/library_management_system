package com.libraryManagementSystem.springProject.repository;

import com.libraryManagementSystem.springProject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends JpaRepository<Users,Long> {

}
