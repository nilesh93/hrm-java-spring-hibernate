/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author nileshjayanandana
 */
public class MethodIdentifier {

    public static String identifyMethod(HttpServletRequest hsr) {
        String method = hsr.getMethod();

        if (method == "POST") {
            method = hsr.getParameter("_method");
        }

        return method;
    }
}
