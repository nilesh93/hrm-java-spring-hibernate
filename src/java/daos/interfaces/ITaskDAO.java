/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.interfaces;

import java.util.List;
import models.Task;

/**
 *
 * @author nileshjayanandana
 */
public interface ITaskDAO {

    /**
     * retrieve task list
     * @return 
     */
    public abstract List getTaskList();

    /**
     * Save or update task
     * @param task 
     */
    public abstract void saveOrUpdateTask(Task task);

    /**
     * Retrieve unassigned tasks
     * @return 
     */
    public abstract List getTaskUnasignedTasks();

    
    /**
     * Get task by Id
     * @param id
     * @return
     * @throws Exception 
     */
    public abstract Task getTaskById(Integer id) throws Exception;
}
