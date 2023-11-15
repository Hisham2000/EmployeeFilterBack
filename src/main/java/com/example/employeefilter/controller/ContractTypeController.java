package com.example.employeefilter.controller;

import com.example.employeefilter.service.ContractTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contractType")
@CrossOrigin()
public class ContractTypeController {
    @Autowired
    ContractTypeService contractTypeService;
    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(contractTypeService.getAll());
    }
}
