package io.github.oengajohn.employee_service.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import io.github.oengajohn.employee_service.entity.Employee;
import io.github.oengajohn.employee_service.model.EmployeeRequest;
import io.github.oengajohn.employee_service.model.EmployeeResponse;
import io.github.oengajohn.employee_service.repository.EmployeeRepository;
import io.github.oengajohn.employee_service.service.EmployeeService;
import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeResponse createEmployee(@Valid EmployeeRequest employeeRequest) {
        Employee employee = modelMapper.map(employeeRequest, Employee.class);
        var savedEmployee = employeeRepository.save(employee);
        EmployeeResponse employeeResponse = modelMapper.map(savedEmployee, EmployeeResponse.class);
        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> list() {
        return employeeRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, EmployeeResponse.class))
                .toList();
    }

    @Override
    public EmployeeResponse getByEmployeeNumber(Integer employeeNumber) {
        return employeeRepository.findById(employeeNumber)
                .map(e -> modelMapper.map(e, EmployeeResponse.class))
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));
    }

    @Override
    public void deleteByEmployeeNumber(Integer employeeNumber) {
        employeeRepository.delete(Employee.builder().id(employeeNumber).build());
    }

}
