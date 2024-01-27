package com.example.EmployeeDirectory.rest;

import com.example.EmployeeDirectory.entity.Employee;
import com.example.EmployeeDirectory.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {
    private EmployeeService employeeServiceDAO;

    public EmployeeRestController(EmployeeService employeeServiceDAO) {
        this.employeeServiceDAO = employeeServiceDAO;
    }


    //Get All
    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return employeeServiceDAO.getAllEmployees();
    }

    //Add Employee
    @PostMapping("/")
    public void addEmployee(@RequestBody Employee employee){
        employeeServiceDAO.addEmployee(employee);
    }

    //Update Employee
    @PutMapping("/")
    public void updateEmployee(@RequestBody Employee employee){
        employeeServiceDAO.updateEmployee(employee);
    }

    //Delete Employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeServiceDAO.deleteEmployee(id);
    }

}
