package com.aroma_Coffee_Hub.aroma_Backend.Repo;

import com.aroma_Coffee_Hub.aroma_Backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee ,Long> {

}
