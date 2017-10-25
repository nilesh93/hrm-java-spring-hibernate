/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import daos.EmployeeDAO;
import daos.TaskDAO;
import java.util.List;
import models.Employee;
import models.Task;

/**
 *
 * @author Nilesh
 */
public class TaskService {

    /**
     * List all tasks
     * @return 
     */
    public static List getTasks() {
        List<Task> tasks = TaskDAO.getTaskList();
        return tasks;
    }

    /**
     * List all tasks where an employee is not assigned
     * @return 
     */
    public static List getUnassignedTasks() {
        List<Task> tasks = TaskDAO.getTaskUnasignedTasks();
        return tasks;
    }

    /**
     * Create Task
     * @param dsc 
     */
    public static void saveTask(String dsc) {
        Task task = new Task();
        task.setDescription(dsc);
        TaskDAO.saveOrUpdateTask(task);
    }

    
    /**
     * Update Task description (PATCH)
     * @param id
     * @param desc 
     */
    public static void updateTask(int id, String desc) throws Exception{
    
        Task task = TaskService.getTaskById(id);
        task.setDescription(desc);
        TaskDAO.saveOrUpdateTask(task);
        
    }
    
    /**
     * Retrieve task details by Id
     * @param taskId
     * @return
     * @throws Exception 
     */
    public static Task getTaskById(int taskId) throws Exception {
        Task task = TaskDAO.getTaskById(taskId);
        return task;
    }

    /**
     * Assign an employee to a task
     * @param taskId
     * @param emp
     * @throws Exception 
     */
    public static void assignEmployee(int taskId, Employee emp) throws Exception {

        if (taskId != 0) {
            Task task = TaskService.getTaskById(taskId);
            task.setEmployee(emp);
            TaskDAO.saveOrUpdateTask(task);
        }
    }

    /**
     * Remove an Employee from a task
     * @param taskId
     * @throws Exception 
     */
    public static void removeTaskAssign(int taskId) throws Exception {

        Task task = TaskService.getTaskById(taskId);
        task.setEmployee(null);
        TaskDAO.saveOrUpdateTask(task);

    }
}
