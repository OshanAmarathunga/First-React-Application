package com.ijse.firstSpring.controller;

import com.ijse.firstSpring.entity.User;
import com.ijse.firstSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> userList=userService.getAllUsers();
        return userList==null?ResponseEntity.status(404).build():ResponseEntity.status(200).body(userList);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        User getUser=userService.getUser(id);
        return getUser==null?ResponseEntity.status(404).build():ResponseEntity.status(200).body(getUser);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser=userService.saveUser(user);
        return savedUser==null?ResponseEntity.status(404).build():ResponseEntity.status(201).body(savedUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,  @RequestBody User user){
        User updatedUser =userService.updateUser(id,user);
        return updatedUser==null?ResponseEntity.status(404).build():ResponseEntity.status(200).body(updatedUser);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
         userService.deleteUser(id);
    }
}
