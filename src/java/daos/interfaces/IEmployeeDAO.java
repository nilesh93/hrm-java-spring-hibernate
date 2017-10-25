/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.interfaces;

import java.util.List;
import models.Employee;

/**
 *
 * @author nileshjayanandana
 */
public interface IEmployeeDAO {

    /**
     * employee list from model
     * @return 
     */
    public abstract List getEmployeeList();

    /**
     * save or update employees
     * @param emp 
     */
    public abstract void saveOrUpdateEmployee(Employee emp);

    
    /**
     * retrieve employee by id
     * @param id
     * @return
     * @throws Exception 
     */
    public abstract Employee getEmployee(Integer id) throws Exception;
}
