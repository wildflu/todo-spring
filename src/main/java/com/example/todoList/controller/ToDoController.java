package com.example.todoList.controller;


import com.example.todoList.model.TodoItem;
import com.example.todoList.model.User;
import com.example.todoList.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {

    private final TodoService todoService;

    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public List<TodoItem> AllItems() {
        return todoService.alltodoList();
    }

    @GetMapping("/list/{item}")
    public ResponseEntity<?> getItem(@PathVariable String item) {
        return todoService.getToDoItem(item);
    }

    @PostMapping("/list/add")
    public ResponseEntity<?> addItemToList(@RequestBody TodoItem todoItem) {
        return todoService.addItemToList(todoItem);
    }
    @DeleteMapping("/list/{item}")
    public ResponseEntity<?> deleteItem(@PathVariable String item) {
        return todoService.deleteItemFromList(item);
    }

    @PutMapping("/list/{item}")
    public ResponseEntity<?> updateItem(@PathVariable String item,@RequestBody TodoItem todoItem) {
        return todoService.updateToDoItem(item, todoItem);
    }
}
