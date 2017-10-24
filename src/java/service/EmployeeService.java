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
}
