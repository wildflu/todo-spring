package com.example.todoList.service;


import com.example.todoList.model.User;
import com.example.todoList.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<?> register(User user) {
        if(userRepository.existsByUserName(user.getUserName())){
            return new ResponseEntity<>("alReady Exists", HttpStatus.FOUND);
        }
        userRepository.save(user);
        return new ResponseEntity<>("register success", HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteUser(String userName) {
        if(userRepository.existsByUserName(userName)){
            User user = userRepository.findByUserName(userName);
            userRepository.delete(user);
            return new ResponseEntity<>("deleted success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found User", HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<?> getUser(String userName) {
        if(userRepository.existsByUserName(userName)) {
            return new ResponseEntity<>(userRepository.findByUserName(userName), HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }
}
