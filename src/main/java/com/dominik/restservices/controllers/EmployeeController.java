package com.dominik.restservices.controllers;

import com.dominik.restservices.entities.Employee;
import com.dominik.restservices.services.EmployeeService;
import com.dominik.restservices.services.Response;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    public Response addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam Date dateOfBirth,
                                @RequestParam String department,
                                @RequestParam String email) {
       return employeeService.addEmployee(firstName, lastName, dateOfBirth, department, email);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public Response deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/changeFirstName")
    public Response changeFirstName(@RequestParam int id,
                                    @RequestParam String firstName){
        return employeeService.changeFirstName(id, firstName);
    }

}
