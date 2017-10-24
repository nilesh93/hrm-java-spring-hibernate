package service;

import daos.RoleDAO;

import java.util.List;

public class RoleService {
    public List getAll(){
        return RoleDAO.get();
    }
}
