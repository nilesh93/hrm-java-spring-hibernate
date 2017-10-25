/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import daos.EmployeeDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.Employee;
import models.Role;

/**
 *
 * @author Nilesh
 */
public class EmployeeService {

    /**
     * Create a new employee
     * @param roleId
     * @param empName 
     */
    public static void saveEmployee(int roleId, String empName) {

        Employee emp = new Employee();
        if (roleId != 0) {
            Role role = new Role();
            role.setId(roleId);
            emp.setRole(role);
        }
        emp.setName(empName);
        EmployeeDAO.saveOrUpdateEmployee(emp);
    }

    /**
     * Get employee list
     * @return 
     */
    public static List getEmployeeList() {
        List<Employee> emps = EmployeeDAO.getEmployeeList();
        return emps;
    }

    /**
     * Update employee partially (PATCH)
     * @param id
     * @param name
     * @throws Exception 
     */
    public static void updateEmployee(int id, String name) throws Exception {

        Employee emp;
        emp = EmployeeDAO.getEmployee(id);
        emp.setName(name);
        EmployeeDAO.saveOrUpdateEmployee(emp);

    }

    /**
     * Retrieve Employee details by ID
     * @param id
     * @return
     * @throws Exception 
     */
    public static Employee getEmployeeById(int id) throws Exception {
        Employee emp = EmployeeDAO.getEmployee(id);
        return emp;
    }

    /**
     * Change role of an Employee
     * @param empId
     * @param roleId
     * @throws Exception 
     */
    public static void changeRole(int empId, int roleId) throws Exception {
        Employee emp;
        emp = EmployeeDAO.getEmployee(empId);
        if (roleId != 0) {
            Role role = new Role();
            role.setId(roleId);
            emp.setRole(role);
        } else {
            emp.setRole(null);
        }
        EmployeeDAO.saveOrUpdateEmployee(emp);

    }
}
