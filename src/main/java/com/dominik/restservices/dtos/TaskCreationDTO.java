package com.dominik.restservices.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.sql.Date;
import java.sql.Timestamp;

public class TaskCreationDTO {

    private long id;
    private String category;
    private String description;
    private int assigned_emp;
    private Date task_finish_date;

}
