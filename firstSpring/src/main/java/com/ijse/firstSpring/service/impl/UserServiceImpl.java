package com.ijse.firstSpring.service.impl;

import com.ijse.firstSpring.entity.User;
import com.ijse.firstSpring.repository.UserRepository;
import com.ijse.firstSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(int id,User user) {
        User findUser=userRepository.findById(id).orElse(null);
        if(findUser!=null){
            findUser.setUsername(user.getUsername());
            findUser.setEmail(user.getEmail());
            findUser.setPassword(user.getPassword());

            return userRepository.save(findUser);
        }else {
            return null;
        }
    }

    @Override
    public void deleteUser(int id) {
         userRepository.deleteById(id);

    }

    @Override
    public User saveUser(User user) {
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userRepository.save(user);
    }


}
