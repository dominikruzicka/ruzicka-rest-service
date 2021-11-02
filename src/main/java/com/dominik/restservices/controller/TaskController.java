package com.dominik.restservices.controller;

import com.dominik.restservices.entity.Task;
import com.dominik.restservices.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired //annotation not needed, left just for clarity
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getTaskById/{id}")
    public ResponseEntity<Object> getTaskByID(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/saveTask")
    public ResponseEntity<Object> saveTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }


}
