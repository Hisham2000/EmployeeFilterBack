package com.example.employeefilter.controller;

import com.example.employeefilter.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@CrossOrigin()
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }


}
