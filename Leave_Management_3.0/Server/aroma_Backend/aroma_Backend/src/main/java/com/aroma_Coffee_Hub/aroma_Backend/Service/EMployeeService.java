package com.aroma_Coffee_Hub.aroma_Backend.Service;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.EmployeeDto;
import com.aroma_Coffee_Hub.aroma_Backend.DTO.EmployeeListDto;

import java.util.List;

public interface EMployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeByID(Long employeeid);

 List<EmployeeDto> getAllEmployess();
 EmployeeDto updateEMployee(Long employeeid, EmployeeDto updateEMployee);
void deleteEmployee(Long employeeid);
EmployeeListDto getAllEmployeesWithCount();

}