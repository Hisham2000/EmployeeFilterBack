package com.example.employeefilter.dto;

import com.example.employeefilter.entity.ContractsTypes;
import com.example.employeefilter.entity.Department;
import com.example.employeefilter.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
    private Long id;
    private String code;
    private String name;
    private String email;
    private Department department;
    private String jobTitle;
    private User directManager;
    private ContractsTypes contractsTypes;
}
