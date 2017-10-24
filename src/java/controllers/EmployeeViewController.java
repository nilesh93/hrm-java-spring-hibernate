/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Employee;
import models.Role;
import models.Task;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import service.EmployeeService;
import service.RoleService;
import service.TaskService;

/**
 * Maps to eview.htm
 * @author Nilesh
 */
public class EmployeeViewController implements Controller {

    /**
     * Handle requests to this controller
     * @param hsr
     * @param hsr1
     * @return
     * @throws Exception 
     */
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

    /**
     * Generates EmployeeView View from employee ID
     * @param id
     * @return 
     */
    private ModelAndView getEmployee(Integer id) {

        ModelAndView mv = new ModelAndView("employee-view");

        try {
            Employee emp = new EmployeeService().getBy(id);
            List<Role> roles = new RoleService().getAll();
            List<Task> tasks = new TaskService().getAll();
            mv.addObject("employee", emp);
            mv.addObject("tasks", tasks);
            mv.addObject("roles", roles);
        } catch (Exception e) {
            mv = new ModelAndView("404");
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * Updates employee through PATCH request
     * @param hsr 
     */
    private void patchEmployee(HttpServletRequest hsr) {
        try {
            int id = Integer.parseInt(hsr.getParameter("id"));
            String name = hsr.getParameter("name");
            new EmployeeService().save(id, name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Change Employee Role by assigning an unassigned Role or removing existing role
     * @param hsr 
     */
    private void changeRole(HttpServletRequest hsr) {
        try {
            int id = Integer.parseInt(hsr.getParameter("id"));
            int roleId = Integer.parseInt(hsr.getParameter("role"));
            new EmployeeService().updateRole(id, roleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add Employee Task from an existing Task
     * @param hsr 
     */
    private void addEmployeeTask(HttpServletRequest hsr) {
        Employee emp;
        try {
            
            Integer taskId = Integer.parseInt(hsr.getParameter("task"));
            if (taskId != 0) {
                Integer empId = Integer.parseInt(hsr.getParameter("id"));
                new TaskService().add(taskId, empId);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Remove Employee Task by removing Employee reference in a Task retrieved from TaskID
     * @param hsr 
     */
    private void removeEmployeeTask(HttpServletRequest hsr) {
        try {
            int taskId = Integer.parseInt(hsr.getParameter("task"));
            if (Integer.parseInt(hsr.getParameter("id")) != 0) {
                new TaskService().removeEmployee(taskId);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
