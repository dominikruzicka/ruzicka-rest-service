package com.dominik.restservices.controllers;

import com.dominik.restservices.entities.Task;
import com.dominik.restservices.services.Response;
import com.dominik.restservices.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/getTaskById/{id}")
    public Task getTaskByID(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/saveTask")
    public ResponseEntity<Object> saveTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }


}
