package com.wcg.employee.mapper;

import com.wcg.employee.dto.EmployeeDto;
import com.wcg.employee.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }

    public static Employee toEntity(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail(),
                employeeDto.getDepartment(),
                employeeDto.getSalary()
        );
    }
}