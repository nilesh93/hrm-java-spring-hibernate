
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Employee;
import models.Role;
import models.Task;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import services.EmployeeService;
import services.RoleService;
import services.TaskService;
import services.interfaces.IEmployeeService;
import services.interfaces.IRoleService;
import services.interfaces.ITaskService;
import util.MethodIdentifier;

/**
 * Maps to eview.htm
 *
 * @author Nilesh
 */
public class EmployeeViewController implements Controller {

    ITaskService tsk = new TaskService();
    IEmployeeService emps = new EmployeeService();
    IRoleService rs = new RoleService();

    /**
     * Handle requests to this controller
     *
     * @param hsr
     * @param hsr1
     * @return
     * @throws Exception
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        Integer id = Integer.parseInt(hsr.getParameter("id"));
        ModelAndView mv = new ModelAndView("employee-view");

        String method = MethodIdentifier.identifyMethod(hsr);
        switch (method) {
            case "GET":
                mv.addObject("flag", false);
                break;

            case "PATCH":
                emps.updateEmployee(Integer.parseInt(hsr.getParameter("id")),
                        hsr.getParameter("name"));
                mv.addObject("flag", true);
                mv.addObject("message", "Employee Updated Successfully!");
                break;

            case "CHANGE_ROLE":
                emps.changeRole(Integer.parseInt(hsr.getParameter("id")),
                        Integer.parseInt(hsr.getParameter("role")));
                mv.addObject("flag", true);
                mv.addObject("message", "Employee Role Updated Successfully!");
                break;

            case "ADD_TASK":
                tsk.assignEmployee(Integer.parseInt(hsr.getParameter("task")),
                        emps.getEmployeeById(Integer.parseInt(hsr.getParameter("id"))));
                mv.addObject("flag", true);
                mv.addObject("message", "Employee Task Added Successfully!");
                break;

            case "REMOVE_TASK":
                tsk.removeTaskAssign(Integer.parseInt(hsr.getParameter("task")));
                mv.addObject("flag", true);
                mv.addObject("message", "Employee Task Removed Successfully!");
                break;

        }
        getEmployee(id, mv);
        mv.addObject("page", "employee");
        return mv;
    }

    /**
     * Generates EmployeeView View from employee ID
     *
     * @param id
     * @return
     */
    private ModelAndView getEmployee(Integer id, ModelAndView mv) {

        try {
            mv.addObject("employee", emps.getEmployeeById(id));
            mv.addObject("tasks", tsk.getUnassignedTasks());
            mv.addObject("roles", rs.getRoles());
        } catch (Exception e) {
            mv = new ModelAndView("404");
            e.printStackTrace();
        }
        return mv;
    }

}

