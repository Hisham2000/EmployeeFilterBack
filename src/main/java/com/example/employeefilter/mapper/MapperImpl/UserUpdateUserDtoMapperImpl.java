package com.example.employeefilter.mapper.MapperImpl;

import com.example.employeefilter.dto.UpdateUserDto;
import com.example.employeefilter.entity.User;
import com.example.employeefilter.mapper.UserUpdateUserDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateUserDtoMapperImpl implements UserUpdateUserDtoMapper {
    @Override
    public User UpdateUserDtoToUser(User user, UpdateUserDto updateUserDto) {
        user.setCode(updateUserDto.getCode());
        user.setName(updateUserDto.getName());
        user.setEmail(updateUserDto.getEmail());
        user.setDepartment(updateUserDto.getDepartment());
        user.setJobTitle(updateUserDto.getJobTitle());
        user.setDirectManager(updateUserDto.getDirectManager());
        user.setContractsTypes(updateUserDto.getContractsTypes());
        return user;
    }
}
