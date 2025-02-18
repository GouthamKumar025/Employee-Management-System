package com.goutham.employee.service;

import com.goutham.employee.entity.EmployeeEntity;
import com.goutham.employee.model.Employee;
import com.goutham.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity>employeeEntity = employeeRepository.findAll();

        List<Employee>employees = employeeEntity.stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmail())).toList();
        return employees;
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(Long id) {
        return null;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);
        return true;
    }

    @Override
    public Employee getEmployeeById(long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setEmail(employee.getEmail());

        employeeRepository.save(employeeEntity);
        return employee;
    }
}
