package com.dominik.restservices.service;

import com.dominik.restservices.dto.EmployeeDTO;
import com.dominik.restservices.dto.TaskDTO;
import com.dominik.restservices.entity.Employee;
import com.dominik.restservices.entity.Task;
import com.dominik.restservices.mapper.EmployeeMapper;
import com.dominik.restservices.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    //@Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    //reduce items returned to what consumer asks for with max value
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public ResponseEntity<Object> getEmployeeById(long id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        EmployeeDTO employeeDTO = employeeMapper.employeeToDTO(employee);
        if (employee != null) {
            return ResponseEntity.ok(employeeDTO);
        } else {
            String responseBody = "Requested ID " + id + " was not found";
            return new ResponseEntity(responseBody, HttpStatus.BAD_REQUEST);
        }
    }


}
