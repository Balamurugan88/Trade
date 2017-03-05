/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.utils;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Balamurugan
 */
public class CustomUtils {

    public static void setStatus(String statusCode, String statusMessage, HttpServletRequest request) {
        request.setAttribute("statusCode", statusCode);
        request.setAttribute("statusMessage", statusMessage);
    }

    public static void forward(String url, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
    
    public static void setPathName(String url, HttpServletRequest request){
        url = request.getContextPath() + url;
        request.setAttribute("pathName", url);
    }
    
     public static void redirect(String url, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       url=request.getContextPath()+"/"+url;
       response.sendRedirect(url);
    }
     
     public static int getId(HttpServletRequest request, String parameterName){
         int id = 0;
         String idString = request.getParameter(parameterName).trim();
         if(!idString.equals("")){
             id = Integer.parseInt(idString);
         }
         return id;
     }

}
