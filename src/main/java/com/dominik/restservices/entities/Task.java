package com.dominik.restservices.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @SequenceGenerator(name = "task_sequence",
                       sequenceName = "task_sequence",
                       allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "assigned_emp", nullable = false)
    private String assigned_emp;

    @Column(name = "task_finish_date", nullable = false)
    private Date task_finish_date;

    @Column(name = "record_created_date", nullable = true)
    private Timestamp record_created_date;

    public Task() {
    }

    public Task(String category, String description, String assigned_emp, Date task_finish_date, Timestamp record_created_date) {
        this.category = category;
        this.description = description;
        this.assigned_emp = assigned_emp;
        this.task_finish_date = task_finish_date;
        this.record_created_date = record_created_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAssigned_emp() {
        return assigned_emp;
    }

    public void setAssigned_emp(String assigned_emp) {
        this.assigned_emp = assigned_emp;
    }

    public Date getTask_finish_date() {
        return task_finish_date;
    }

    public void setTask_finish_date(Date task_finish_date) {
        this.task_finish_date = task_finish_date;
    }

    public Timestamp getRecord_created_date() {
        return record_created_date;
    }

    public void setRecord_created_date(Timestamp record_created_date) {
        this.record_created_date = record_created_date;
    }
}
