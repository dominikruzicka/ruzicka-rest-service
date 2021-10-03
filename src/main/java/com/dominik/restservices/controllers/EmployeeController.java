package com.dominik.restservices.controllers;

import com.dominik.restservices.entities.Employee;
import com.dominik.restservices.services.EmployeeService;
import com.dominik.restservices.services.EmployeeServiceNotInUse;
import com.dominik.restservices.services.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();

    //http://localhost:8080/getEmployee/225
    @GetMapping("/getEmployee/{id}")
    public Response getEmployee(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }


    @PostMapping("/addEmployee")
    public String addEmployee(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam Date dateOfBirth, //create date format checker
                              @RequestParam String department,
                              @RequestParam String email) {    //create email checker (regex)
       return employeeService.addEmployee(firstName, lastName, dateOfBirth, department, email);
    }

/*
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
    }
*/
}
