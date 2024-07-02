package com.aroma_Coffee_Hub.aroma_Backend.Service.IMPL;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.EmployeeDto;
import com.aroma_Coffee_Hub.aroma_Backend.DTO.EmployeeListDto;
import com.aroma_Coffee_Hub.aroma_Backend.Exception.ResourceNotFoundException;
import com.aroma_Coffee_Hub.aroma_Backend.Mapper.Employeemapper;
import com.aroma_Coffee_Hub.aroma_Backend.Repo.EmployeeRepo;
import com.aroma_Coffee_Hub.aroma_Backend.Service.EMployeeService;
import com.aroma_Coffee_Hub.aroma_Backend.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceIMpl  implements EMployeeService {

    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = Employeemapper.mapToEmployee(employeeDto);
        Employee saveEmployee = employeeRepo.save(employee);
        return Employeemapper.mapToEmployeeDto(saveEmployee);
    }


    @Override
    public EmployeeDto getEmployeeByID(Long employeeid) {
        Employee employee = employeeRepo.findById(employeeid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not Exist" + employeeid));
        return Employeemapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployess() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(employee -> Employeemapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEMployee(Long employeeid, EmployeeDto updateEmployee) {
        Employee employee = employeeRepo.findById(employeeid).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not existing with given Id" + employeeid)
        );

        employee.setFirstname(updateEmployee.getFirstName());
        employee.setLastname(updateEmployee.getLastName());
        employee.setGender(updateEmployee.getGender());
        employee.setRole(updateEmployee.getRole());
        Employee updatedEmployeeobj = employeeRepo.save(employee);
        return Employeemapper.mapToEmployeeDto(updatedEmployeeobj);
    }


    @Override
    public void deleteEmployee(Long employeeid) {

        Employee employee = employeeRepo.findById(employeeid).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not existing with given Id" + employeeid)
        );
        employeeRepo.deleteById(employeeid);
    }

    @Override
    public EmployeeListDto getAllEmployeesWithCount() {
        int totalCount = (int) employeeRepo.count();
        return new EmployeeListDto(totalCount);
    }

}