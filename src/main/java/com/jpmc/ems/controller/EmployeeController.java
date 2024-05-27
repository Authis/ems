package com.jpmc.ems.controller;

import com.jpmc.ems.entity.Employee;
import com.jpmc.ems.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.jpmc.ems.common.ControllerUtils.fold;
import java.util.List;

@RestController
@RequestMapping("/api/ems/")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @Tag(name = "Department", description = "Filter Employees based on the Department")
    @GetMapping("/department/{name}")
    public ResponseEntity<?> getEmployees(@PathVariable String name){
        System.out.println(">>>>>>"+name);
        System.out.println(employeeService.getEmployeesByDepartment(name));
         return fold(employeeService.getEmployeesByDepartment(name));
     }

    @Tag(name = "Salary", description = "Filter Employees based on the Salary")
    @GetMapping("/salary")
    public List<Employee> getEmployees(@RequestParam double salary){
        return employeeService.getEmployeeBySalary(salary);
    }

    @Tag(name = "Employee", description = "Get all Employees")
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
