package com.azeem.restwiththymleaf.service;

import com.azeem.restwiththymleaf.doa.EmployeeRespository;
import com.azeem.restwiththymleaf.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplemetation implements EmployeeService{

    private EmployeeRespository employeeRespository;

    @Autowired
    public EmployeeServiceImplemetation(EmployeeRespository employeeRespository){
        this.employeeRespository = employeeRespository;
    }

    @Override
    public List<Employee> listEmployees() {

        return employeeRespository.findAllByOrderByLastName();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> result = Optional.of(employeeRespository.getById(id));

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return theEmployee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRespository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRespository.deleteById(id);
    }
}
