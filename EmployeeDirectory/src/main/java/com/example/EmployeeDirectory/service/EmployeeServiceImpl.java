package com.example.EmployeeDirectory.service;

import com.example.EmployeeDirectory.dao.EmployeeRepository;
import com.example.EmployeeDirectory.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findbyId(int id) {
        Optional<Employee> idfound = employeeRepository.findById(id);
        if(!idfound.isPresent()){
            return null ;
        }
        else
            return idfound.get();
    }

    @Override
    public void addEmployee(@RequestBody  Employee e) {
        employeeRepository.save(e);
    }

    @Override
    public void updateEmployee(@RequestBody Employee e) {
        employeeRepository.save(e);
    }

    @Override
    public void deleteEmployee(int id) {
        System.out.println(id);
        employeeRepository.deleteById(id);
    }


}
