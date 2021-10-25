package com.dominik.restservices.services;

import com.dominik.restservices.entities.Task;
import com.dominik.restservices.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task getTaskById(int id){
        return taskRepository.findById(id).orElse(null);
    }





}
