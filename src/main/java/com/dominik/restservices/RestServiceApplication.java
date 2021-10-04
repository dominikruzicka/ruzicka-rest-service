package com.dominik.restservices;

import com.dominik.restservices.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.sql.*;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class RestServiceApplication {

    public static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("restservices", getProperties());

    public static void main(String[] args) {


		SpringApplication.run(RestServiceApplication.class, args);

        //ENTITY_MANAGER_FACTORY.close(); // problem - closes too early, when to close it?

    }

    private static HashMap getProperties() {
        HashMap result = new HashMap();

        result.put("javax.persistence.jdbc.user", System.getenv("MYSQL_USERNAME"));
        result.put( "javax.persistence.jdbc.password", System.getenv("MYSQL_PASSWORD"));
        result.put("javax.persistence.jdbc.url", System.getenv("MYSQL_URL"));

        return result;
    }


/*
    public static void changeFirstNameEmployee(int emp_id, String first_name){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Employee employee = null;
        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            employee = entityManager.find(Employee.class, emp_id);
            employee.setFirst_name(first_name);
            entityManager.persist(employee);
            entityTransaction.commit();
        } catch(Exception e){
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


*/

}
