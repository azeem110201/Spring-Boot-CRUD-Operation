package com.azeem.restwiththymleaf.service;

import com.azeem.restwiththymleaf.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listEmployees();
    Employee getEmployeeById(int id);
    void saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
