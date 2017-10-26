/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.interfaces;

import java.util.List;
import models.Role;

/**
 *
 * @author nileshjayanandana
 */
public interface IRoleDAO {
    /**
     * list of roles
     * @return 
     */
    public abstract List<Role> get();
    
    /**
     * save or update a role
     * @param role 
     */
    public abstract void saveOrUpdateRole(Role role);
}
