package com.aroma_Coffee_Hub.aroma_Backend.Mapper;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.EmployeeDto;
import com.aroma_Coffee_Hub.aroma_Backend.entity.Employee;

public class Employeemapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstname()); // Map firstName
        employeeDto.setLastName(employee.getLastname()); // Map lastName
        employeeDto.setGender(employee.getGender());
        employeeDto.setRole(employee.getRole());
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstname(employeeDto.getFirstName()); // Map firstName
        employee.setLastname(employeeDto.getLastName()); // Map lastName
        employee.setGender(employeeDto.getGender());
        employee.setRole(employeeDto.getRole());
        return employee;
    }
}