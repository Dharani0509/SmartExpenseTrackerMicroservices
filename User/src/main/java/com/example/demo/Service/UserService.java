package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(long userId);  
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(long userId);
}
