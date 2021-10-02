package com.dominik.restservices.models;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employees implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "emp_id", nullable = false)
    private int emp_id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "birth_date", nullable = false)
    private Date birth_date;  //Is it the best datatype? Check later

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "record_created_date", nullable = true)
    private Timestamp record_created_date; //Is it the best datatype? Check later

    public int getEmp_id() {
        return emp_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }
    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getRecord_created_date() {
        return record_created_date;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "emp_id=" + emp_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth_date=" + birth_date +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", record_created_date=" + record_created_date +
                '}';
    }
}