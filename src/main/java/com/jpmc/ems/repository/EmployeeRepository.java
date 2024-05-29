package com.jpmc.ems.repository;

import com.jpmc.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentNameContaining(String name);
    List<Employee> findBySalaryBetween(double minSalary,double maxSalary);
}
