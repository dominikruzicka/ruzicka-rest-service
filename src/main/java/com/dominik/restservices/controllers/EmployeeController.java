package com.dominik.restservices.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/employees") //add later and edit also postman requests
public class EmployeeController {
/*
    private EmployeeService employeeService = new EmployeeService();

    //http://localhost:8080/getEmployee/225
    // ResponseEntity class in Spring web (use instead of current solution with my interface)
    @GetMapping("/getEmployee/{id}")
    public Response getEmployee(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }


    //go for request body here, DTO
    @PostMapping("/addEmployee")
    public Response addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam Date dateOfBirth,
                                @RequestParam String department,
                                @RequestParam String email) {
       return employeeService.addEmployee(firstName, lastName, dateOfBirth, department, email)  ;
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
*/
}
