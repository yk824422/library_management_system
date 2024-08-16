package com.libraryManagementSystem.springProject.service;

import com.libraryManagementSystem.springProject.entity.Users;
import com.libraryManagementSystem.springProject.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private usersRepository usersRepository;


    public Users addUser (Users user){
        return usersRepository.save(user);
    }

   public List<Users> findAllUsers(){
        return usersRepository.findAll();
    }

    public Optional<Users> findUserByID(Long iD){
        return  usersRepository.findById(iD);
    }
}
