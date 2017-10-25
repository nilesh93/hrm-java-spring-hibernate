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
import services.RoleService;
import util.MethodIdentifier;

/**
 * Maps to roles.htm
 *
 * @author nileshjayanandana
 */
public class RoleController implements Controller {

    /**
     * Handles Controller Requests
     *
     * @param hsr
     * @param hsr1
     * @return
     * @throws Exception
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = null;
        mv = get();
        
        String method = MethodIdentifier.identifyMethod(hsr);
        switch (method) {
            case "GET":
                mv.addObject("flag", false);
                break;

            case "POST":
                RoleService.saveRole(hsr.getParameter("title"));

                mv.addObject("flag", true);
                mv.addObject("message", "Role Added Successfully!");
                break;

            case "PUT":
                RoleService.updateRole(Integer.parseInt(hsr.getParameter("id")),
                        hsr.getParameter("title"));

                mv.addObject("flag", true);
                mv.addObject("message", "Role Edited Successfully!");
                break;

            case "DELETE":
                break;
        }

        mv.addObject("page", "role");
        return mv;
    }

    /**
     * Returns Role List View
     *
     * @return
     */
    private ModelAndView get() {

        ModelAndView mv = new ModelAndView("roles");

        try {
            mv.addObject("roles", RoleService.getRoles());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
