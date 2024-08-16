package com.libraryManagementSystem.springProject.controller;

import com.libraryManagementSystem.springProject.entity.Users;
import com.libraryManagementSystem.springProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUser() {
        return userService.findAllUsers();
    }

    @PostMapping
    public Users addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public Users putUser(@RequestBody Users user, @PathVariable Long id) {
        Optional<Users> existingUser = userService.findUserByID(id);
        if (existingUser.isPresent()) {
            Users updatedUser = existingUser.get();
            // Update the properties of the existing user with the new values
            updatedUser.setFirstName(user.getFirstName()); // Example: Assuming `name` is a field in `Users`
            updatedUser.setLastName(user.getLastName()); // Update other fields as needed
            // Save the updated user
            return userService.addUser(updatedUser);
        } else {
            // If the user doesn't exist, return a 404 Not Found response or add the new user
            return userService.addUser(user); // or throw a new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @PatchMapping("/{id}")
    public Users patchUser(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Optional<Users> existingUserOptional = userService.findUserByID(id);
        if (existingUserOptional.isPresent()) {
            Users existingUser = existingUserOptional.get();

            // Apply updates if they exist in the request body
            if (updates.containsKey("firstName")) {
                existingUser.setFirstName((String) updates.get("firstName"));
            }
            if (updates.containsKey("lastName")) {
                existingUser.setLastName((String) updates.get("lastName"));
            }

            // Save the updated user
            return userService.addUser(existingUser);
        } else {
            // If the user doesn't exist, return a 404 Not Found response
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }


    @GetMapping("/{id}")
    public Users getUserByiD(@PathVariable Long id) {
        return userService.findUserByID(id).orElse(null);
    }


}
