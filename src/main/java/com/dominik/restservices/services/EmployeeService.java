package com.dominik.restservices.services;

import com.dominik.restservices.entities.Employee;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

import static com.dominik.restservices.RestServiceApplication.ENTITY_MANAGER_FACTORY;

public class EmployeeService {

    ErrorResponse errorResponse = new ErrorResponse();
    ValidResponse validResponse = new ValidResponse();

    public String addEmployee(String first_name, String last_name, Date birth_date, String department, String email){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Employee employee = null;
        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            employee = new Employee();
            employee.setFirst_name(first_name);
            employee.setLast_name(last_name);
            employee.setBirth_date(birth_date);
            employee.setDepartment(department);
            employee.setEmail(email);
            entityManager.persist(employee);
            entityTransaction.commit();
            return "Employee successfully added";
        } catch(Exception e){
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
            e.printStackTrace();
            return "Error when inserting employee: " + employee.toString();
        } finally {
            entityManager.close();
        }
    }

    public Response getEmployeeById(int emp_id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT emp FROM Employee emp WHERE emp.emp_id = :employeeId";

        TypedQuery<Employee> typedQuery = entityManager.createQuery(strQuery, Employee.class);
        typedQuery.setParameter("employeeId", emp_id);
        Employee employee = null;
        try{
            employee = typedQuery.getSingleResult();
            return employee;
        } catch (NoResultException e){
            e.printStackTrace();
            return errorResponse;
        } finally {
            entityManager.close();
        }
    }



    public List<Employee> getEmployees() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT emp FROM Employee emp WHERE emp.emp_id IS NOT NULL";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(strQuery, Employee.class);
        List<Employee> employees = typedQuery.getResultList();
        return employees;
    }
        /*
        try{
            employees = typedQuery.getResultList();
            return employees;
        } catch (NoResultException e){
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
*/

    public Response deleteEmployee(int id){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Employee employee = null;
        try{
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            employee = entityManager.find(Employee.class, id);
            entityManager.remove(employee);
            entityTransaction.commit();
            return validResponse;
        } catch(Exception e){
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
            e.printStackTrace();
            return errorResponse;
        } finally {
            entityManager.close();
        }
    }

    }
