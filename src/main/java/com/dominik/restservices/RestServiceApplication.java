package com.dominik.restservices;

import com.dominik.restservices.models.Employees;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.sql.*;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class RestServiceApplication {
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("restservices", getProperties());

	public static void main(String[] args) {
        System.out.println(System.getenv("TEST_VAR"));


        addEmployee("HUSTOVLAS", "PECINKA", new Date(1985-11-30), "IT", "jirkasirka@gmail.com");
   /*     addEmployee("Arnost", "Pirko", new Date(1990-06-01), "IT", "arnostpirko@gmail.com");

        getEmployee(45);

        getEmployees();

        changeFirstNameEmployee(55, "Bohumil");

        deleteEmployee(65);
        deleteEmployee(75);
*/
    ENTITY_MANAGER_FACTORY.close();

       /*
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-01.cleardb.com:3306/heroku_9b91aa3319220b2", "b6810fde1eaea4", "b1877770");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from test_connection_table");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("idtest"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
		SpringApplication.run(RestServiceApplication.class, args);
	}

    private static HashMap getProperties() {
        HashMap result = new HashMap();

        // Read the properties from a file instead of hard-coding it here.
        // Or pass the password in from the command-line.
        result.put("javax.persistence.jdbc.user", System.getenv("MYSQL_USERNAME"));
        result.put( "javax.persistence.jdbc.password", System.getenv("MYSQL_PASSWORD"));
        result.put("javax.persistence.jdbc.url", System.getenv("MYSQL_URL"));

        return result;
    }

    public static void addEmployee(String first_name, String last_name, Date birth_date, String department, String email){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Employees employee = null;
        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            employee = new Employees();
            employee.setFirst_name(first_name);
            employee.setLast_name(last_name);
            employee.setBirth_date(birth_date);
            employee.setDepartment(department);
            employee.setEmail(email);
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

    public static void getEmployee(int emp_id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT emp FROM Employees emp WHERE emp.emp_id = :employeeId";

        TypedQuery<Employees> typedQuery = entityManager.createQuery(strQuery, Employees.class);
        typedQuery.setParameter("employeeId", emp_id);
        Employees employee = null;
        try{
            employee = typedQuery.getSingleResult();
            System.out.println(employee.toString());
        } catch (NoResultException e){
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void getEmployees() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT emp FROM Employees emp WHERE emp.emp_id IS NOT NULL";
        TypedQuery<Employees> typedQuery = entityManager.createQuery(strQuery, Employees.class);
        List<Employees> employees;
        try{
            employees = typedQuery.getResultList();
            employees.forEach(employee -> System.out.println(employee.toString()));
        } catch (NoResultException e){
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void changeFirstNameEmployee(int emp_id, String first_name){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Employees employee = null;
        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            employee = entityManager.find(Employees.class, emp_id);
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

    public static void deleteEmployee(int id){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Employees employee = null;
        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            employee = entityManager.find(Employees.class, id);
            entityManager.remove(employee);
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


}
