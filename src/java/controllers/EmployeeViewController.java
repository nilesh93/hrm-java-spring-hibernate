/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import daos.RoleDAO;
import daos.TaskDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Employee;
import models.Role;
import models.Task;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Nilesh
 */
public class EmployeeViewController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        String method = hsr.getMethod();
        Integer id = Integer.parseInt(hsr.getParameter("id"));
        if (method == "POST") {
            method = hsr.getParameter("_method");
        }
        switch (method) {
            case "GET":
                mv = getEmployee(id);
                mv.addObject("flag", false);

                break;

            case "PATCH":
                patchEmployee(hsr);
                mv = getEmployee(id);
                mv.addObject("flag", true);
                mv.addObject("message", "Employee Updated Successfully!");
                break;

            case "CHANGE_ROLE":
                changeRole(hsr);
                mv = getEmployee(id);
                mv.addObject("flag", true);
                mv.addObject("message", "Employee Role Updated Successfully!");
                break;

            case "ADD_TASK":
                addEmployeeTask(hsr);
                mv = getEmployee(id);
                mv.addObject("flag", true);
                mv.addObject("message", "Employee Task Added Successfully!");
                break; 
                
            case "REMOVE_TASK":
                removeEmployeeTask(hsr);
                mv = getEmployee(id);
                mv.addObject("flag", true);
                mv.addObject("message", "Employee Task Removed Successfully!");
                break; 

        }
        mv.addObject("page", "employee");
        return mv;
    }

    private ModelAndView getEmployee(Integer id) {

        ModelAndView mv = new ModelAndView("employee-view");

        try {
            Employee emp = EmployeeDAO.getEmployee(id);
            List<Role> roles = RoleDAO.get();
            List<Task> tasks = TaskDAO.getTaskUnasignedTasks();
            mv.addObject("employee", emp);
            mv.addObject("tasks", tasks);
            mv.addObject("roles", roles);
        } catch (Exception e) {
            mv = new ModelAndView("404");
            e.printStackTrace();
        }
        return mv;
    }

    private void patchEmployee(HttpServletRequest hsr) {
        Employee emp;
        try {
            emp = EmployeeDAO.getEmployee(Integer.parseInt(hsr.getParameter("id")));
            emp.setName(hsr.getParameter("name"));
            EmployeeDAO.saveOrUpdateEmployee(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeRole(HttpServletRequest hsr) {
        Employee emp;
        try {
            emp = EmployeeDAO.getEmployee(Integer.parseInt(hsr.getParameter("id")));
            int roleId = Integer.parseInt(hsr.getParameter("role"));
            if (roleId != 0) {
                Role role = new Role();
                role.setId(roleId);
                emp.setRole(role);
            } else {
                emp.setRole(null);
            }
            EmployeeDAO.saveOrUpdateEmployee(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void addEmployeeTask(HttpServletRequest hsr) {
        Employee emp;
        try {
            
            int taskId = Integer.parseInt(hsr.getParameter("task"));
            if (taskId != 0) {
                Task task = TaskDAO.getTaskById(taskId);
                emp = EmployeeDAO.getEmployee(Integer.parseInt(hsr.getParameter("id")));
                task.setEmployee(emp);
                TaskDAO.saveOrUpdateTask(task);
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private void removeEmployeeTask(HttpServletRequest hsr) {
        
        try {
            
            int taskId = Integer.parseInt(hsr.getParameter("task"));
            if (Integer.parseInt(hsr.getParameter("id")) != 0) {
                Task task = TaskDAO.getTaskById(taskId);
                task.setEmployee(null);
                TaskDAO.saveOrUpdateTask(task);
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
