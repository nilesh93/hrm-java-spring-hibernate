/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import daos.RoleDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Employee;
import models.Role;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Maps to route employee.htm
 * @author Nilesh
 */
public class EmployeeController implements Controller {

    /**
     * Handle  requests
     * @param hsr
     * @param hsr1
     * @return
     * @throws Exception 
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = null;
        String method = hsr.getMethod();
        if (method == "POST") {
            method = hsr.getParameter("_method");
        }
        switch (method) {
            case "GET":
                mv = get();
                mv.addObject("flag", false);

                break;

            case "POST":
                save(hsr);
                mv = get();
                mv.addObject("flag", true);
                mv.addObject("message", "Employee Added Successfully!");
                break;

        }
        mv.addObject("page", "employee");
        return mv;
    }

    /**
     * Generate Employee List View
     *
     * @return
     */
    private ModelAndView get() {

        ModelAndView mv = new ModelAndView("employees");

        try {
            List<Employee> emps = EmployeeDAO.getEmployeeList();
            List<Role> roles = RoleDAO.get();
            mv.addObject("roles", roles);
            mv.addObject("employees", emps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * Save new Employee
     *
     * @param hsr
     */
    private void save(HttpServletRequest hsr) {
        Employee emp = new Employee();
        int roleId = Integer.parseInt(hsr.getParameter("role"));
        if (roleId != 0) {
            Role role = new Role();
            role.setId(roleId);
            emp.setRole(role);
        }
        emp.setName(hsr.getParameter("name"));

        EmployeeDAO.saveOrUpdateEmployee(emp);

    }

}
