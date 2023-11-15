package com.example.employeefilter.service;

import com.example.employeefilter.entity.User;
import com.example.employeefilter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public List<User> getAll() {
        return userRepo.findAll();
    }
}
