package com.example.todoList.service;

import com.example.todoList.model.TodoItem;
import com.example.todoList.model.User;
import com.example.todoList.repository.ToDoRepository;
import com.example.todoList.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final ToDoRepository toDoRepository;

    public TodoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    public List<TodoItem> alltodoList() {
        return toDoRepository.findAll();
    }

    public ResponseEntity<?> addItemToList(TodoItem todoitem) {
        if(toDoRepository.findByItem(todoitem.getItem()) != null){
            return new ResponseEntity<>("alReady Exists", HttpStatus.FOUND);
        }
        toDoRepository.save(todoitem);
        return new ResponseEntity<>("item add success", HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteItemFromList(String item) {
        if(toDoRepository.findByItem(item) != null){
            TodoItem todoItem = toDoRepository.findByItem(item);
             toDoRepository.delete(todoItem);
            return new ResponseEntity<>("deleted success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found item", HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<?> getToDoItem(String item) {
        if(toDoRepository.findByItem(item) != null) {
            return new ResponseEntity<>(toDoRepository.findByItem(item), HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> updateToDoItem(String item, TodoItem todoItem) {
        if(toDoRepository.findByItem(item) != null) {
            TodoItem newItem = toDoRepository.findByItem(item);
            newItem.setItem(todoItem.getItem());
            newItem.setUserName(todoItem.getUserName());
            toDoRepository.save(newItem);
            return new ResponseEntity<>("updated success", HttpStatus.OK);
        }
        return new ResponseEntity<>("updated denied", HttpStatus.NOT_FOUND);
    }


}
