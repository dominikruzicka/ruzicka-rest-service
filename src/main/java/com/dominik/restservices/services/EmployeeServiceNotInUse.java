package com.dominik.restservices.services;

import com.dominik.restservices.entities.Employee;
import com.dominik.restservices.repository.EmployeeRepositoryNotInUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

//@Service
//@Repository
//@Transactional
public class EmployeeServiceNotInUse {
/*
    @PersistenceContext
    private EntityManager entityManager;

    public int insert(Employee employee){
        entityManager.persist(employee);
        return employee.getEmp_id();
    }
 */
/*
    @Autowired
    private EmployeeRepositoryNotInUse employeeRepository;

    //POST
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //GET
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    //DELETE
    public void deleteEmployeeById(int id){
        employeeRepository.deleteById(id);
    }

    //PUT
    public Employee updateEmployee(Employee employee){
        Employee existingEmployee = employeeRepository.findById(employee.getEmp_id()).orElse(null);
        existingEmployee.setFirst_name(employee.getFirst_name());
        existingEmployee.setLast_name(employee.getLast_name());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setEmail(employee.getEmail());
        return employeeRepository.save(existingEmployee);
    }

*/

}
