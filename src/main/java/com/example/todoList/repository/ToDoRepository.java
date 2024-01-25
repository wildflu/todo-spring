package com.example.todoList.repository;

import com.example.todoList.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends MongoRepository<TodoItem, String> {
    TodoItem findByItem(String item);
}
