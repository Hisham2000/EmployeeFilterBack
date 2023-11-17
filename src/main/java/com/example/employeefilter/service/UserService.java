package com.example.employeefilter.service;

import com.example.employeefilter.dto.UpdateUserDto;
import com.example.employeefilter.entity.User;
import com.example.employeefilter.mapper.UserUpdateUserDtoMapper;
import com.example.employeefilter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserUpdateUserDtoMapper userUpdateUserDtoMapper;
    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User update(UpdateUserDto updateUserDto) {
        User user = userRepo.findById(updateUserDto.getId()).get();
        user = userUpdateUserDtoMapper.UpdateUserDtoToUser(user, updateUserDto);
        return userRepo.save(user);
    }
}
