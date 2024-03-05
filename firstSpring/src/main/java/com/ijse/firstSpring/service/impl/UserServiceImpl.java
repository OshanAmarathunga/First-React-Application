package com.ijse.firstSpring.service.impl;

import com.ijse.firstSpring.entity.User;
import com.ijse.firstSpring.repository.UserRepository;
import com.ijse.firstSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(User user) {
         userRepository.delete(user);
             return true;

    }

    @Override
    public User saveUser(User user) {
       return userRepository.save(user);
    }


}
