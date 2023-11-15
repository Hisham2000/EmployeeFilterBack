package com.example.employeefilter.controller;

import com.example.employeefilter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin()
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(userService.getAll());
    }
}
