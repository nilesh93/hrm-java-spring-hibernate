package service;

import daos.EmployeeDAO;
import daos.TaskDAO;
import models.Employee;
import models.Task;

import java.util.List;

public class TaskService {
    public List getAll() {
        return TaskDAO.getTaskUnasignedTasks();
    }

    public void add(Integer taskId, Integer empId) throws Exception {
        Task task = TaskDAO.getTaskById(taskId);
        Employee emp = EmployeeDAO.getEmployee(empId);
        task.setEmployee(emp);
        TaskDAO.saveOrUpdateTask(task);
    }

    public void removeEmployee(int taskId) throws Exception {
        Task task = TaskDAO.getTaskById(taskId);
        task.setEmployee(null);
        TaskDAO.saveOrUpdateTask(task);
    }

    public void save(String desc) {
        Task task = new Task();
        task.setDescription(desc);
        TaskDAO.saveOrUpdateTask(task);
    }

    public void update(Integer id, String desc) {
        Task task = new Task();
        task.setDescription(desc);
        task.setId(id);
        TaskDAO.saveOrUpdateTask(task);
    }
}
