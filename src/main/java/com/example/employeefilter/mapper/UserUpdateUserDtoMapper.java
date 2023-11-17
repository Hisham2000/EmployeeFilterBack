package com.example.employeefilter.mapper;

import com.example.employeefilter.dto.UpdateUserDto;
import com.example.employeefilter.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserUpdateUserDtoMapper {
    User UpdateUserDtoToUser(User user, UpdateUserDto updateUserDto);
}
