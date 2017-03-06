/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.filter;

import com.clri.dto.Users;
import com.clri.utils.CustomUtils;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

public class AuthorizationFilter implements Filter {
    
    public static final String ADMIN="ADMIN";
    public static final String CUSTOMER ="CUSTOMER";

    public void init(FilterConfig filterConfig) throws ServletException {
        String roles = filterConfig.getInitParameter("roles");
        String excludeUrl = filterConfig.getInitParameter("excludePatterns");
        excludePatterns = excludeUrl.split(",");
        System.out.println("=== The roles are === " + roles);
        if (roles == null || "".equals(roles)) {
            roleNames = new String[0];
        } else {
            roles.trim();
            // use the new split method of JDK 1.4
            roleNames = roles.split("\\s*,\\s*");
        }
        onFailure = filterConfig.getInitParameter("onFailure");
        if (onFailure == null || "".equals(onFailure)) {
            onFailure = "/failure.jsp";
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        Users user = (Users) session.getAttribute("user");
        
        ActionErrors errors = new ActionErrors();
        String url = req.getServletPath();
        boolean flag=false;
//        System.out.println("==== The exclud url pattern is " + excludePatterns);
//        System.out.println("==== The  url  is " + url);

        if (CustomUtils.isStringInArray(url, excludePatterns, false)) {
            flag=true;
           // chain.doFilter(request, response);
            if (url.equals("/LoginAuthenticate")) {
               // res.sendRedirect("customer/list");
            } else if (url.equals("/logout")) {
                 session.invalidate();
               // res.sendRedirect("/index.jsp");
            } else {
                req.getRequestDispatcher(url).forward(req, res);
            }

        }
       if (user != null) {
            boolean hasRole = false;
            for (int i = 0; i < roleNames.length; i++) {
                   if(ADMIN.equalsIgnoreCase(user.getUserRole().toLowerCase()) ||
                           CUSTOMER.equalsIgnoreCase(user.getUserRole().toLowerCase())){
                      hasRole=true;
                      break;  
                   }
                   
            }
            if (!hasRole) {
                errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
                        "error.authorization.required"));
            }
        }
        if (errors.isEmpty( )) {
            chain.doFilter(request, response);
        } else {
            req.setAttribute(Globals.ERROR_KEY, errors);
            req.getRequestDispatcher(onFailure).forward(req, res);
        }
    }

    public void destroy() {
    }
    private String[] roleNames;
    private String onFailure;
    private String[] excludePatterns;
}
