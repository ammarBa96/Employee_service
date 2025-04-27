package io.github.oengajohn.employee_service.service;

import java.util.List;

import io.github.oengajohn.employee_service.model.EmployeeRequest;
import io.github.oengajohn.employee_service.model.EmployeeResponse;
import jakarta.validation.Valid;

public interface EmployeeService {

    public EmployeeResponse createEmployee (@Valid EmployeeRequest employeeRequest);

    public List<EmployeeResponse> list();

    public EmployeeResponse getByEmployeeNumber(Integer employeeNumber);

    public void deleteByEmployeeNumber(Integer employeeNumber);

}
