package com.dominik.restservices.controllers;

import com.dominik.restservices.entities.Task;
import com.dominik.restservices.services.Response;
import com.dominik.restservices.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;// = new TaskService();

    @GetMapping("/getTaskById/{id}")
    public Task getTaskByID(@PathVariable int id) {
        return taskService.getTaskById(id);
    }


}
