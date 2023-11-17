package com.example.employeefilter.controller;

import com.example.employeefilter.dto.UpdateUserDto;
import com.example.employeefilter.entity.User;
import com.example.employeefilter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/update")
    @Secured("Manager")
    public ResponseEntity updateUser(@RequestBody UpdateUserDto updateUserDto)
    {
        return ResponseEntity.ok(userService.update(updateUserDto));
    }
}
