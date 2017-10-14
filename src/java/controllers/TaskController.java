/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RoleDAO;
import daos.TaskDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.Task;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Nilesh
 */
public class TaskController implements Controller {

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
                mv.addObject("message", "Task Added Successfully!");
                break;

            case "PUT":
                update(hsr);

                mv = get();
                mv.addObject("flag", true);
                mv.addObject("message", "Task Edited Successfully!");
                break;

            case "DELETE":
                mv = get();
                break;
        }
        mv.addObject("page", "task");
        return mv;
    }

    private ModelAndView get() {

        ModelAndView mv = new ModelAndView("tasks");

        try {
            List<Task> tasks = TaskDAO.getTaskList();
            mv.addObject("tasks", tasks);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    private void save(HttpServletRequest hsr) {
        Task task = new Task();
        task.setDescription(hsr.getParameter("desc"));
        TaskDAO.saveOrUpdateTask(task);
    }

    private void update(HttpServletRequest hsr) {

        Task task = new Task();
        task.setDescription(hsr.getParameter("desc"));
        task.setId(Integer.parseInt(hsr.getParameter("id")));
        TaskDAO.saveOrUpdateTask(task);

    }
}
