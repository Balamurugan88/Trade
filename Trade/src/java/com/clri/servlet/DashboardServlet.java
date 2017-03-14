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
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Balamurugan
 */
@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {

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
       MajorCustomersDAO majorCustomerDAO = new MajorCustomersDAO();
       String importCustomerList = new Gson().toJson(majorCustomerDAO.getList(CommonConstants.IMPORT) );
       request.setAttribute("importCustomerList",importCustomerList);
       MajorProductionsDAO majorProductionsDAO = new MajorProductionsDAO();
       String importProductionList = new Gson().toJson(majorProductionsDAO.getList(CommonConstants.IMPORT) );
       request.setAttribute("importProductionList",importProductionList);
       //Export Details
       String exportCustomerList = new Gson().toJson(majorCustomerDAO.getList(CommonConstants.EXPORT) );
       request.setAttribute("exportCustomerList",exportCustomerList);
       String exportProductionList = new Gson().toJson(majorProductionsDAO.getList(CommonConstants.EXPORT) );
       request.setAttribute("exportProductionList",exportProductionList);
       CustomUtils.setPathName(CommonConstants.DASHABOARD_PAGE, request);
       CustomUtils.forward(CommonConstants.DASHBOARD_JSP, request, response);
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
