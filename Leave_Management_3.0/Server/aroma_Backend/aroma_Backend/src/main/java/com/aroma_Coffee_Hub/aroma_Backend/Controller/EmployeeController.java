package com.aroma_Coffee_Hub.aroma_Backend.Controller;

import com.aroma_Coffee_Hub.aroma_Backend.DTO.EmployeeDto;
import com.aroma_Coffee_Hub.aroma_Backend.DTO.EmployeeListDto;
import com.aroma_Coffee_Hub.aroma_Backend.Service.EMployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EMployeeService eMployeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = eMployeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeByID(@PathVariable("id") Long employeeid){
        EmployeeDto employeeDto = eMployeeService.getEmployeeByID(employeeid);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees= eMployeeService.getAllEmployess();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeid, @RequestBody EmployeeDto updateEmployee){
        EmployeeDto employeeDto = eMployeeService.updateEMployee(employeeid, updateEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeid){
        eMployeeService.deleteEmployee(employeeid);
        return ResponseEntity.ok("Employee deleted Successfully!");
    }

    @GetMapping("/all-with-count")
    public ResponseEntity<EmployeeListDto> getAllEmployeesWithCount() {
        EmployeeListDto employeeListDto = eMployeeService.getAllEmployeesWithCount();
        return ResponseEntity.ok(employeeListDto);
    }
}
