/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import daos.EmployeeDAO;
import daos.interfaces.IEmployeeDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.Employee;
import models.Role;
import services.interfaces.IEmployeeService;

/**
 *
 * @author Nilesh
 */
public class EmployeeService implements IEmployeeService {

    IEmployeeDAO empd = new EmployeeDAO();
    /**
     * Create a new employee
     * @param roleId
     * @param empName 
     */
    public  void saveEmployee(int roleId, String empName) {

        Employee emp = new Employee();
        if (roleId != 0) {
            Role role = new Role();
            role.setId(roleId);
            emp.setRole(role);
        }
        emp.setName(empName);
        empd.saveOrUpdateEmployee(emp);
    }

    /**
     * Get employee list
     * @return 
     */
    public  List getEmployeeList() {
        List<Employee> emps = empd.getEmployeeList();
        return emps;
    }

    /**
     * Update employee partially (PATCH)
     * @param id
     * @param name
     * @throws Exception 
     */
    public void updateEmployee(int id, String name) throws Exception {

        Employee emp;
        emp = empd.getEmployee(id);
        emp.setName(name);
        empd.saveOrUpdateEmployee(emp);

    }

    /**
     * Retrieve Employee details by ID
     * @param id
     * @return
     * @throws Exception 
     */
    public  Employee getEmployeeById(int id) throws Exception {
        Employee emp = empd.getEmployee(id);
        return emp;
    }

    /**
     * Change role of an Employee
     * @param empId
     * @param roleId
     * @throws Exception 
     */
    public  void changeRole(int empId, int roleId) throws Exception {
        Employee emp;
        emp = empd.getEmployee(empId);
        if (roleId != 0) {
            Role role = new Role();
            role.setId(roleId);
            emp.setRole(role);
        } else {
            emp.setRole(null);
        }
        empd.saveOrUpdateEmployee(emp);

    }
}
