package service;

import daos.EmployeeDAO;
import models.Employee;
import models.Role;

import java.util.List;

public class EmployeeService {

    public List getAll() {
        return EmployeeDAO.getEmployeeList();
    }

    public void save(int roleId, String name) {
        Employee emp = new Employee();
        if (roleId != 0) {
            Role role = new Role();
            role.setId(roleId);
            emp.setRole(role);
        }
        emp.setName(name);

        EmployeeDAO.saveOrUpdateEmployee(emp);
    }

    public Employee getBy(Integer id) throws Exception {
        return EmployeeDAO.getEmployee(id);
    }

    public void update(Integer id, String name) throws Exception {
        Employee emp = getBy(id);
        emp.setName(name);
        EmployeeDAO.saveOrUpdateEmployee(emp);
    }

    public void updateRole(int id, int roleId) throws Exception {
        Employee emp = getBy(id);
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
