package com.example.employeefilter.repository;

import com.example.employeefilter.entity.ContractsTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractTypesRepo extends JpaRepository<ContractsTypes, Long> {
}
