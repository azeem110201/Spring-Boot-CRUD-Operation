package com.azeem.restwiththymleaf.doa;

import com.azeem.restwiththymleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
    // add method for sort by last name
    public List<Employee> findAllByOrderByLastName();
}
