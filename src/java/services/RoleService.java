/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import daos.RoleDAO;
import java.util.List;
import models.Role;

/**
 *
 * @author Nilesh
 */
public class RoleService {

    public static List getRoles() {
        List<Role> roles = RoleDAO.get();
        return roles;
    }

    public static void saveRole(String title) {
        Role role = new Role();
        role.setTitle(title);
        RoleDAO.saveOrUpdateRole(role);
    }

    public static void updateRole(int id, String title) {
        Role role = new Role();
        role.setTitle(title);
        role.setId(id);
        RoleDAO.saveOrUpdateRole(role);
    }
}
