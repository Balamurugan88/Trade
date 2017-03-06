/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.servlet;

import com.clri.dao.CategoryDAO;
import com.clri.dbutils.DataBaseConnection;
import com.clri.dto.Category;
import com.clri.utils.CommonConstants;
import com.clri.utils.CustomMessage;
import com.clri.utils.CustomUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CDURAI
 */
public class CategoryServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        int count =0;
        //if(path.equals(CommonConstants.CATEGORY_LIST)){
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category();
        //}
        if (path.equals(CommonConstants.CATEGORY_SAVE_UPDATE)) {
            category.setArticleCode(CustomUtils.getId(request,"articleCode"));
            category.setName(request.getParameter("name"));
            count = categoryDAO.addUpdateCategory(category);
            if (count == 0) {
                CustomUtils.setStatus(CommonConstants.ERROR_MSG_CODE, CustomMessage.getMessage("CATEGORY_SAVE_ERROR"), request);
            } else {
                CustomUtils.setStatus(CommonConstants.SUCCESS_MSG_CODE, CustomMessage.getMessage("CATEGORY_SAVE_SUCCESS"), request);
            }
        } else if (path.equals(CommonConstants.CATEGORY_DELETE)) {
            int id = Integer.parseInt(request.getParameter("articleCode"));
            count = categoryDAO.deleteCategory(id);
            if (count == 0) {
                CustomUtils.setStatus(CommonConstants.ERROR_MSG_CODE, CustomMessage.getMessage("CATEGORY_DELETE_ERROR"), request);
            } else {
                CustomUtils.setStatus(CommonConstants.SUCCESS_MSG_CODE, CustomMessage.getMessage("CATEGORY_DELETE_SUCCESS"), request);
            }
        } else if (path.equals(CommonConstants.CATEGORY_EDIT)) {
            int id = Integer.parseInt(request.getParameter("articleCode"));
            category = categoryDAO.getById(id);
            request.setAttribute("category", category);
        }
        List<Category> categoryList = categoryDAO.getList();
        request.setAttribute("categoryList", categoryList);
        CustomUtils.setPathName(CommonConstants.CATEGORY_LIST, request);
        CustomUtils.forward(CommonConstants.CATEGORY_LIST_JSP, request, response);

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
