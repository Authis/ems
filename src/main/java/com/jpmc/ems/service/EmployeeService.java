package com.jpmc.ems.service;

import com.jpmc.ems.entity.Employee;
import com.jpmc.ems.repository.EmployeeRepository;
import io.atlassian.fugue.Either;
import lombok.AllArgsConstructor;
 import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Either<String, List<Employee>> getEmployeesByDepartment(String name){
       List<Employee> employeeList = employeeRepository.findByDepartmentName(name);
        if(employeeList.isEmpty()){
            return Either.left("No employees found for department: "+name);
        }else{
            return Either.right(employeeList);
        }

    }

    public List<Employee> getEmployeeBySalary(double salary){
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

}
