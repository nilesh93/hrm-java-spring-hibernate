/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import daos.interfaces.ITaskDAO;
import java.util.List;
import models.Task;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Nilesh
 */
public class TaskDAO implements ITaskDAO{

    /**
     * Get Task List
     * @return 
     */
    public  List getTaskList() {

        List<Task> taskList = null;
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Task");
            taskList = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }

        } finally {
            session.close();
        }

        return taskList;

    }

    /**
     * Save or Update Task
     * @param task 
     */
    public  void saveOrUpdateTask(Task task) {

        Transaction transaction = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(task);
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
     * Retrieve Unassigned Tasks as List
     * @return 
     */
    public  List getTaskUnasignedTasks() {

        List<Task> taskList = null;
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Task where employee_id = null");
            taskList = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }

        } finally {
            session.close();
        }

        return taskList;

    }

    /**
     * Get a Task by ID
     * @param id
     * @return
     * @throws Exception 
     */
    public  Task getTaskById(Integer id) throws Exception {

        List<Task> taskList = null;
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Task where id=" + id.toString());
            taskList = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }

        } finally {
            session.close();
        }

        if (taskList.equals(null) || taskList.size() == 0) {
            throw new Exception("NOT FOUND");
        }
        return taskList.get(0);

    }
}
