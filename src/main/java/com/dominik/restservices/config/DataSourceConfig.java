package com.dominik.restservices.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    // Passing following info using Bean and DataSourceBuilder.
    // Dont want to use application.properties so it is not pushed on Github
    // Locally as well as on Heroku information is read from Environment variables
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(System.getenv("MYSQL_URL"));
        dataSourceBuilder.username(System.getenv("MYSQL_USERNAME"));
        dataSourceBuilder.password(System.getenv("MYSQL_PASSWORD"));
        return dataSourceBuilder.build();
    }
}
