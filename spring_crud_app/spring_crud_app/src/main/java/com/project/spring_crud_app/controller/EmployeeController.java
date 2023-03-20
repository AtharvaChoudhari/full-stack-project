package com.project.spring_crud_app.controller;

import com.project.spring_crud_app.model.Employee;
import com.project.spring_crud_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Add new employee
    @PostMapping("/addEmployee")
    @CrossOrigin(origins = "http://localhost:4200/")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // Add more than 1 employee

    @PostMapping("/addEmployee")
    @CrossOrigin(origins = "http://localhost:4200/")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees) {
        return employeeService.addAllEmployees(employees);
    }

    // Get employee by Id
    @GetMapping("/getEmployees")
    @CrossOrigin(origins = "http://localhost:4200/")
    public List<Employee> getEmployeeById() {
        return employeeService.getallemp();
    }

    @GetMapping("/getEmployeeByID/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeesByID(id);
    }
    // Get employee by name
    @GetMapping("/getEmployeeByName/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    // Update employee
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // Delete employee
    @DeleteMapping("/deleteEmployeeById/{id}")
    public boolean deleteEmployeeById(@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);
    }
}
