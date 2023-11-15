package com.example.employeefilter.service;

import com.example.employeefilter.entity.Department;
import com.example.employeefilter.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }
}
