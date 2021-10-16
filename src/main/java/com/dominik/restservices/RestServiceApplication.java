package com.dominik.restservices;

import com.dominik.restservices.entities.Employee;
import com.dominik.restservices.entities.Task;
import com.dominik.restservices.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

    @Bean
    CommandLineRunner commandLineRunner(TaskRepository taskRepository){
        return args -> {
            Task task = new Task();
          taskRepository.save(task);
        };
    }

    private static HashMap getProperties() {
        HashMap result = new HashMap();

        result.put("javax.persistence.jdbc.user", System.getenv("MYSQL_USERNAME"));
        result.put( "javax.persistence.jdbc.password", System.getenv("MYSQL_PASSWORD"));
        result.put("javax.persistence.jdbc.url", System.getenv("MYSQL_URL"));

        return result;
    }

}
