package com.goutham.employee.service;

import com.goutham.employee.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();

    ResponseEntity<Map<String, Boolean>> deleteEmployeeById(Long id);

    boolean deleteEmployee(Long id);

    Employee getEmployeeById(long id);

    Employee updateEmployee(Long id, Employee employee);
}
