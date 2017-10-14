/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import models.Employee;
import models.Role;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Nilesh
 */
public class EmployeeDAO {

    /**
     * Get Employee List from Query
     * @return Employee List
     */
    public static List getEmployeeList() {

        List<Employee> employeeList = null;
        Transaction transaction = null;
        Session session = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Employee");
            employeeList = query.list();
            transaction.commit();

        } catch (HibernateException e) {

            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }

        } finally {
            session.close();
        }

        return employeeList;

    }

    /**
     * Save or Update an Employee
     * @param emp
     */
    public static void saveOrUpdateEmployee(Employee emp) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(emp);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
    }
    
    /**
     * Get Employee Details from an ID
     * @param id
     * @return Employee
     */
    public static Employee getEmployee(Integer id) throws Exception {

        List<Employee> result = null;
        Transaction transaction = null;
        Session session = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Employee where id = "+ id.toString());
            result = query.list();
            transaction.commit();
           

        } catch (HibernateException e) {

            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }

        } finally {
            session.close();
        }

        if(result.equals(null) || result.size() == 0){
            throw new Exception("NOT FOUND");
        }
        return result.get(0);

    }

}
