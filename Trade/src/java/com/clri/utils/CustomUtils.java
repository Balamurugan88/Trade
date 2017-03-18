/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.utils;

import com.clri.dto.Users;
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
    
    public static int getRequestInt(HttpServletRequest request,String key,String defaultValue){
        String defaultString = request.getParameter(key);
        if(defaultString == null){
            defaultString = defaultValue;
        }
       return Integer.parseInt(defaultString);
    }
    
    public static void displayDeleteMesssage(int count,HttpServletRequest request) throws IOException{
         if (count == 0) {
                CustomUtils.setStatus(CommonConstants.ERROR_MSG_CODE, CustomMessage.getMessage("COMMON_DELETE_ERROR"), request);
            } else {
                CustomUtils.setStatus(CommonConstants.SUCCESS_MSG_CODE, CustomMessage.getMessage("COMMON_DELETE_SUCCESS"), request);
            }
    }

    public static void forward(String url, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    public static String getUrl(HttpServletRequest request) {
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        String serverPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        url = url.replace(serverPath, "");
        url = url.substring(url.lastIndexOf("?") + 1);
        return url;
    }

    public static void setPathName(String url, HttpServletRequest request) {
        url = request.getContextPath() + url;
        request.setAttribute("pathName", url);
    }

    public static void redirect(String url, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        url = request.getContextPath() + "/" + url;
        response.sendRedirect(url);
    }

    public static int getId(HttpServletRequest request, String parameterName) {
        int id = 0;
        String idString = request.getParameter(parameterName).trim();
        if (!idString.equals("")) {
            id = Integer.parseInt(idString);
        }
        return id;
    }

    public static boolean isAdmin(HttpServletRequest request) {
        boolean isAdmin = false;
        if (request.getSession().getAttribute("user") != null) {
            Users user = (Users) request.getSession().getAttribute("user");
            if (user.getUserRole().equalsIgnoreCase(CommonConstants.ADMIN)) {
                isAdmin = true;
            }
        }
        return isAdmin;
    }

    public static boolean isStringInArray(String item, String[] array, boolean ignoreCase) {
        if (array == null) {
            return false;
        }

        boolean result = false;

        int size = array.length;
        for (int i = 0; i < size; i++) {
            String tmp = array[i];
            if (tmp != null) {
                if (ignoreCase) {
                    if (tmp.equalsIgnoreCase(item)) {
                        result = true;
                        break;
                    }
                } else {
                    if (tmp.equals(item)) {
                        result = true;
                        break;
                    }
                }
            } else {
                if (item == null) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

}
