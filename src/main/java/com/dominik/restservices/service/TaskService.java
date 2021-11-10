package com.dominik.restservices.service;

import com.dominik.restservices.dto.TaskDTO;
import com.dominik.restservices.entity.Task;
import com.dominik.restservices.mapper.TaskMapper;
import com.dominik.restservices.repository.TaskRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    //@Autowired
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper){
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    //todo: reduce items returned to what consumer asks for with max value
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public ResponseEntity<Object> getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        TaskDTO taskDTO = taskMapper.taskToDTO(task);
        if (task != null) {
            return ResponseEntity.ok(taskDTO);
        } else {
            String responseBody = "Requested ID " + id + " was not found";
            return new ResponseEntity(responseBody, HttpStatus.BAD_REQUEST);
        }
    }

    //Use Mapper for DTO -> DAO
    public ResponseEntity<Object> saveTask(Task task){
       String responseBody;
        if(task.getCategory() != null
            && task.getDescription() != null
            && task.getAssigned_emp() != 0
            && task.getTask_finish_date() != null) {
            taskRepository.save(task);
            responseBody = "Task successfully saved with id: " + task.getId();
            return ResponseEntity.ok(responseBody);
        } else {
            responseBody = "Incorrect request - one or more required elements missing";
            return new ResponseEntity(responseBody, HttpStatus.BAD_REQUEST);
        }
    }

}
