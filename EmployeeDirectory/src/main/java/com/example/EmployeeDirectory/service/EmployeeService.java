package com.example.EmployeeDirectory.service;

import com.example.EmployeeDirectory.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee findbyId(int id) ;
    void addEmployee(Employee e);
    void updateEmployee(Employee e);
    void deleteEmployee(int id);

}
