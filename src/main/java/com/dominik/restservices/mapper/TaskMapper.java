package com.dominik.restservices.mapper;

import com.dominik.restservices.dto.TaskDTO;
import com.dominik.restservices.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDTO taskToDTO(Task task);
    Task DTOtoTask(TaskDTO taskDTO);
}
