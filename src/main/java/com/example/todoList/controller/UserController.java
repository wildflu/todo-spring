package com.example.todoList.controller;

import com.example.todoList.model.User;
import com.example.todoList.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> AllUsers() {
        return userService.allUsers();
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<?> getUser(@PathVariable String userName) {
        return userService.getUser(userName);
    }

    @PostMapping("users/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return userService.register(user);
    }
    @DeleteMapping("user/{userName}")
    public ResponseEntity<?> deleteUser(@PathVariable String userName) {
        return userService.deleteUser(userName);
    }

}
