package com.dominik.restservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.HashMap;

@SpringBootApplication
public class RestServiceApplication {

  //  public static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("restservices", getProperties());

    public static void main(String[] args) {

		SpringApplication.run(RestServiceApplication.class, args);

    }

    private static HashMap getProperties() {
        HashMap result = new HashMap();

        result.put("javax.persistence.jdbc.user", System.getenv("MYSQL_USERNAME"));
        result.put( "javax.persistence.jdbc.password", System.getenv("MYSQL_PASSWORD"));
        result.put("javax.persistence.jdbc.url", System.getenv("MYSQL_URL"));

        return result;
    }

}
