package com.example.employeefilter.repository;

import com.example.employeefilter.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<Role, Long> {
}
