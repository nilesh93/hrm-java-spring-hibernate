/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import daos.RoleDAO;
import daos.interfaces.IRoleDAO;
import java.util.List;
import models.Role;
import services.interfaces.IRoleService;

/**
 *
 * @author Nilesh
 */
public class RoleService implements IRoleService{

    IRoleDAO rd = new RoleDAO();
    /**
     * List Roles
     * @return 
     */
    public  List getRoles() {
        List<Role> roles = rd.get();
        return roles;
    }

    /**
     * Save Role
     * @param title 
     */
    public  void saveRole(String title) {
        Role role = new Role();
        role.setTitle(title);
        rd.saveOrUpdateRole(role);
    }

    /**
     * Update the entire Role Object (PUT)
     * @param id
     * @param title 
     */
    public  void updateRole(int id, String title) {
        Role role = new Role();
        role.setTitle(title);
        role.setId(id);
        rd.saveOrUpdateRole(role);
    }
}
