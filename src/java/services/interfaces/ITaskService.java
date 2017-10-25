/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import java.util.List;
import models.Employee;
import models.Task;

/**
 *
 * @author nileshjayanandana
 */
public interface ITaskService {

    /**
     * get task list
     * @return 
     */
    public abstract List getTasks();

    /**
     * get unassigned tasks
     * @return 
     */
    public abstract List getUnassignedTasks();

    
    /**
     * save task
     * @param dsc 
     */
    public abstract void saveTask(String dsc);
    
    /**
     * Update task details
     * @param id
     * @param desc
     * @throws Exception 
     */

    public abstract void updateTask(int id, String desc) throws Exception;

    /**
     * Get task details by Id
     * @param taskId
     * @return
     * @throws Exception 
     */
    public abstract Task getTaskById(int taskId) throws Exception;

    /**
     * assign an employee to task
     * @param taskId
     * @param emp
     * @throws Exception 
     */
    public abstract void assignEmployee(int taskId, Employee emp) throws Exception;

    /**
     * remove an employee from task
     * @param taskId
     * @throws Exception 
     */
    public abstract void removeTaskAssign(int taskId) throws Exception;
}
