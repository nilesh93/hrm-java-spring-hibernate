/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import java.util.List;

/**
 *
 * @author nileshjayanandana
 */
public interface IRoleService {

    /**
     * Retrieve Roles
     * @return 
     */
    public abstract List getRoles();
    
    /**
     * Create Role
     * @param title 
     */
    public abstract void saveRole(String title);
    
    /**
     * Update Role
     * @param id
     * @param title 
     */
    public abstract void updateRole(int id, String title);
}
