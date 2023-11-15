package com.example.employeefilter.service;

import com.example.employeefilter.entity.ContractsTypes;
import com.example.employeefilter.repository.ContractTypesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractTypeService {
    @Autowired
    ContractTypesRepo contractTypesRepo;

    public List<ContractsTypes> getAll() {
        return contractTypesRepo.findAll();
    }
}
