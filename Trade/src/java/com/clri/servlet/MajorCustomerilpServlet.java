/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clri.servlet;

import com.clri.dao.MajorCustomerilpDAO;
import com.clri.dto.MajorCustomerilp;
import com.clri.utils.CommonConstants;
import com.clri.utils.CustomUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Balamurugan
 */
public class MajorCustomerilpServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        int count = 0;
        MajorCustomerilpDAO majorCustomerilpDAO = new MajorCustomerilpDAO();
        MajorCustomerilp majorCustomerilp = new MajorCustomerilp();
        HttpSession session = request.getSession();
        if (session.getAttribute("uploadCount") != null) {
            String message = session.getAttribute("uploadCount").toString() + " rows uploaded";
            CustomUtils.setStatus(CommonConstants.SUCCESS_MSG_CODE, message, request);
            session.setAttribute("uploadCount", null);
        }
    }
}