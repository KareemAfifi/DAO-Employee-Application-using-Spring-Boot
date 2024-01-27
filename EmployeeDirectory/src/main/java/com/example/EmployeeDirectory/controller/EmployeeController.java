package com.example.EmployeeDirectory.controller;

import com.example.EmployeeDirectory.dao.EmployeeRepository;
import com.example.EmployeeDirectory.entity.Employee;
import com.example.EmployeeDirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/",method = RequestMethod.GET)
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //Methods:
    @GetMapping("/employees")
    public String listEmployees(Model themodel){
        List<Employee> list = employeeService.getAllEmployees();
        themodel.addAttribute("employees", list) ;
        return "list-employees";
    }

    @GetMapping("/showForm")
    public String addEmployeeform(Model themodel){
        themodel.addAttribute("newemployee", new Employee()) ;
        return "showForm";
    }

    @PostMapping("/save")
    public String employeeadded(@ModelAttribute("newemployee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate")
    public String updateEmployeeform(@RequestParam("employeeId") int id, Model themodel){
        Employee to_be_updated = employeeService.findbyId(id);
        themodel.addAttribute("newemployee", to_be_updated);
        return "showForm";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployeeById(@RequestParam("employeeId") int id){
        employeeService.deleteEmployee(id);
        return "redirect:employees";
    }


}
