package com.wcg.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wcg.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}