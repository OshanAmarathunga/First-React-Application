package com.ijse.firstSpring.service;

import com.ijse.firstSpring.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUser(int id);
    User updateUser(int id,User user);
    void deleteUser(int id);
    User saveUser( User user);


}
