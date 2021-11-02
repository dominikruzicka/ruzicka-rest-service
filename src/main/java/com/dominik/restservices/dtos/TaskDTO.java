package com.dominik.restservices.dtos;

import java.sql.Date;
import java.sql.Timestamp;

public class TaskDTO {

    private long id;
    private String category;
    private String description;
    private int assigned_emp;
    private Date task_finish_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAssigned_emp() {
        return assigned_emp;
    }

    public void setAssigned_emp(int assigned_emp) {
        this.assigned_emp = assigned_emp;
    }

    public Date getTask_finish_date() {
        return task_finish_date;
    }

    public void setTask_finish_date(Date task_finish_date) {
        this.task_finish_date = task_finish_date;
    }

}
