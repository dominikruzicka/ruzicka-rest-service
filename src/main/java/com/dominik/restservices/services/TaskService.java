package com.dominik.restservices.services;

import com.dominik.restservices.entities.Task;
import com.dominik.restservices.repository.TaskRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
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

}
