package io.github.oengajohn.employee_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.oengajohn.employee_service.model.EmployeeRequest;
import io.github.oengajohn.employee_service.model.EmployeeResponse;
import io.github.oengajohn.employee_service.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @PostMapping
    public EmployeeResponse createEmployee (@RequestBody @Valid EmployeeRequest employeeRequest) {
        return employeeService.createEmployee(employeeRequest);
    }

    @GetMapping
    public List<EmployeeResponse> list () {
        return employeeService.list();
    }

    @GetMapping("/byEmployeeNumber")
    public EmployeeResponse getByemployeeNumber(@RequestParam(value = "employeeNumber") Integer employeeNumber) {
        return employeeService.getByEmployeeNumber(employeeNumber);
    }

    @DeleteMapping
    public void deleteByEmployeeNumber(@RequestParam(value = "employeeNumber") Integer employeeNumber) {
        employeeService.deleteByEmployeeNumber(employeeNumber);
    }
}
