/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RoleDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author nileshjayanandana
 */
public class RoleController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        switch (hsr.getMethod()) {
            case "GET": 
                mv = get();
                break;
                
            case "POST":
                save(hsr);
                mv = get();
               
                break;
                
            case "PUT":
                mv = get();
                break;
                
            case "DELETE":
                mv = get();
                break;
        }

        return mv;
    }

    private ModelAndView get() {
        
        ModelAndView mv = new ModelAndView("roles");

        try {
            List<Role> roles = RoleDAO.get();

            mv.addObject("roles", roles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    
     private void save(HttpServletRequest hsr) {
        

        System.out.println("----- title -----");
        System.out.println(hsr.getParameter("title"));

    
        
    }
}
