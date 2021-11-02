package com.dominik.restservices.services;

import com.dominik.restservices.dtos.TaskDTO;
import com.dominik.restservices.entities.Task;
import com.dominik.restservices.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    //reduce items returned to what consumer asks for with max value
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public ResponseEntity<Object> getTaskById(Long id) {
        // return taskRepository.findById(id).orElse(null);
        Task task = taskRepository.findById(id).orElse(null);
        TaskDTO taskDTO = null;
        if (task != null) {
            taskDTO = convertToTaskDTO(task);
            return ResponseEntity.ok(taskDTO);
        } else {
            String responseBody = "Requested ID " + id + " was not found";
            return new ResponseEntity(responseBody, HttpStatus.BAD_REQUEST);

        }

    }

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
            responseBody = "Incorrect request - validate your request body";
            return new ResponseEntity(responseBody, HttpStatus.BAD_REQUEST);
        }
    }

    private TaskDTO convertToTaskDTO(Task task){
            TaskDTO taskDTO = new TaskDTO();

            if (task != null) {
                taskDTO.setId(task.getId());
                taskDTO.setCategory(task.getCategory());
                taskDTO.setDescription(task.getDescription());
                taskDTO.setAssigned_emp(task.getAssigned_emp());
                taskDTO.setTask_finish_date(task.getTask_finish_date());
            }
            return taskDTO;
        }

}
