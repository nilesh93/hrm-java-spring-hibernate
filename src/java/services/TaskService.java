/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import daos.EmployeeDAO;
import daos.TaskDAO;
import daos.interfaces.ITaskDAO;
import java.util.List;
import models.Employee;
import models.Task;
import services.interfaces.ITaskService;

/**
 *
 * @author Nilesh
 */
public class TaskService implements ITaskService {

    ITaskDAO tsk = new TaskDAO();
    /**
     * List all tasks
     * @return 
     */
    public  List getTasks() {
        List<Task> tasks = tsk.getTaskList();
        return tasks;
    }

    /**
     * List all tasks where an employee is not assigned
     * @return 
     */
    public  List getUnassignedTasks() {
        List<Task> tasks = tsk.getTaskUnasignedTasks();
        return tasks;
    }

    /**
     * Create Task
     * @param dsc 
     */
    public  void saveTask(String dsc) {
        Task task = new Task();
        task.setDescription(dsc);
        tsk.saveOrUpdateTask(task);
    }

    
    /**
     * Update Task description (PATCH)
     * @param id
     * @param desc 
     */
    public  void updateTask(int id, String desc) throws Exception{
    
        Task task = this.getTaskById(id);
        task.setDescription(desc);
        tsk.saveOrUpdateTask(task);
        
    }
    
    /**
     * Retrieve task details by Id
     * @param taskId
     * @return
     * @throws Exception 
     */
    public  Task getTaskById(int taskId) throws Exception {
        Task task = tsk.getTaskById(taskId);
        return task;
    }

    /**
     * Assign an employee to a task
     * @param taskId
     * @param emp
     * @throws Exception 
     */
    public  void assignEmployee(int taskId, Employee emp) throws Exception {

        if (taskId != 0) {
            Task task = this.getTaskById(taskId);
            task.setEmployee(emp);
            tsk.saveOrUpdateTask(task);
        }
    }

    /**
     * Remove an Employee from a task
     * @param taskId
     * @throws Exception 
     */
    public  void removeTaskAssign(int taskId) throws Exception {

        Task task = this.getTaskById(taskId);
        task.setEmployee(null);
        tsk.saveOrUpdateTask(task);

    }
}
