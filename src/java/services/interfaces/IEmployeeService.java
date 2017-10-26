/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import java.util.List;
import models.Employee;

/**
 *
 * @author nileshjayanandana
 */
public interface IEmployeeService {

    /**
     * Save employee
     * @param roleId
     * @param empName 
     */
    public abstract void saveEmployee(int roleId, String empName);

    /**
     * Get list of employees
     * @return 
     */
    public abstract List getEmployeeList();

    
    /**
     * Update employee details
     * @param id
     * @param name
     * @throws Exception 
     */
    public abstract void updateEmployee(int id, String name) throws Exception;

    /**
     * get employee details by id
     * @param id
     * @return
     * @throws Exception 
     */
    public abstract Employee getEmployeeById(int id) throws Exception;

    /**
     * change employee role
     * @param empId
     * @param roleId
     * @throws Exception 
     */
    public abstract void changeRole(int empId, int roleId) throws Exception;
 
}
