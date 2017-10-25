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

    public static List getTasks() {
        List<Task> tasks = TaskDAO.getTaskList();
        return tasks;
    }

    public static List getUnassignedTasks() {
        List<Task> tasks = TaskDAO.getTaskUnasignedTasks();
        return tasks;
    }

    public static void saveTask(String dsc) {
        Task task = new Task();
        task.setDescription(dsc);
        TaskDAO.saveOrUpdateTask(task);
    }

    
    public static void updateTask(int id, String desc){
    
        Task task = new Task();
        task.setDescription(desc);
        task.setId(id);
        TaskDAO.saveOrUpdateTask(task);
        
    }
    
    public static Task getTaskById(int taskId) throws Exception {
        Task task = TaskDAO.getTaskById(taskId);
        return task;
    }

    public static void assignEmployee(int taskId, Employee emp) throws Exception {

        if (taskId != 0) {
            Task task = TaskService.getTaskById(taskId);
            task.setEmployee(emp);
            TaskDAO.saveOrUpdateTask(task);
        }
    }

    public static void removeTaskAssign(int taskId) throws Exception {

        Task task = TaskService.getTaskById(taskId);
        task.setEmployee(null);
        TaskDAO.saveOrUpdateTask(task);

    }
}
