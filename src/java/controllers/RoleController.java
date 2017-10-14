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
        String method = hsr.getMethod();
        if (method == "POST") {
            method = hsr.getParameter("_method");
        }
        switch (method) {
            case "GET":
                mv = get();
                mv.addObject("flag", false);

                break;

            case "POST":
                save(hsr);
                mv = get();
                mv.addObject("flag", true);
                mv.addObject("message", "Role Added Successfully!");
                break;

            case "PUT":
                update(hsr);

                mv = get();
                mv.addObject("flag", true);
                mv.addObject("message", "Role Edited Successfully!");
                break;

            case "DELETE":
                mv = get();
                break;
        }
        mv.addObject("page", "role");
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
        Role role = new Role();
        role.setTitle(hsr.getParameter("title"));
        RoleDAO.saveOrUpdateRole(role);

    }

    private void update(HttpServletRequest hsr) {

        Role role = new Role();
        role.setTitle(hsr.getParameter("title"));
        role.setId(Integer.parseInt(hsr.getParameter("id")));
        RoleDAO.saveOrUpdateRole(role);

    }
}
