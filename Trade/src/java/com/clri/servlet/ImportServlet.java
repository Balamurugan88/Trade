/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.servlet;

import com.clri.dao.MajorCustomersDAO;
import com.clri.dao.MajorProductionsDAO;
import com.clri.utils.CommonConstants;
import com.clri.utils.CustomUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Balamurugan
 */
@WebServlet(name = "ImportServlet", urlPatterns = {"/import/*", "/admin/import/delete"})
public class ImportServlet extends HttpServlet {

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
        String path = CustomUtils.getUrl(request);
        MajorCustomersDAO majorCustomersDAO = new MajorCustomersDAO();
        MajorProductionsDAO majorProductionsDAO = new MajorProductionsDAO();
        String url = "";
        String jsp = "";

        int category = CustomUtils.getRequestInt(request, "category", "1");
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        int id = CustomUtils.getRequestInt(request, "id", "0");
        if (session.getAttribute("uploadCount") != null) {
            String message = session.getAttribute("uploadCount").toString() + " rows uploaded";
            CustomUtils.setStatus(CommonConstants.SUCCESS_MSG_CODE, message, request);
            session.setAttribute("uploadCount", null);
        }
        if (path.equals(CommonConstants.IMPORT_CUSTOMER)
                || (path.equals(CommonConstants.IMPORT_CUSTOMER_DELETE)
                && CommonConstants.CUSTOMER_UPLOAD.equalsIgnoreCase(type))) {
            if (id != 0) {
                int count = majorCustomersDAO.delete(id);
                CustomUtils.displayDeleteMesssage(count, request);
            }
            jsp = CommonConstants.IMPORT_CUSTOMER_JSP;
            url = CommonConstants.IMPORT_CUSTOMER+"?category="+category;
            request.setAttribute("customerList", majorCustomersDAO.getList(CommonConstants.IMPORT, category));
        } else {
            if (id != 0) {
                int count = majorProductionsDAO.delete(id);
                CustomUtils.displayDeleteMesssage(count, request);
            }
            jsp = CommonConstants.IMPORT_PRODUCTION_JSP;
            url = CommonConstants.IMPORT_PRODUCTION+"?category="+category;
            request.setAttribute("prodList", majorProductionsDAO.getList(CommonConstants.IMPORT, category));

        }
        CustomUtils.setPathName(url, request);
        CustomUtils.forward(jsp, request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
