package io.github.oengajohn.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.oengajohn.employee_service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    
}
