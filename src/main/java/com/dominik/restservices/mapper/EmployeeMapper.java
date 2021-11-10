package com.dominik.restservices.mapper;

import com.dominik.restservices.dto.EmployeeDTO;
import com.dominik.restservices.dto.TaskDTO;
import com.dominik.restservices.entity.Employee;
import com.dominik.restservices.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO employeeToDTO(Employee employee);
    Employee DTOtoEmployee(EmployeeDTO employeeDTO);
}