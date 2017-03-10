/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clri.servlet;

import com.clri.dao.MajorProductionilpDAO;
import com.clri.dto.MajorProductionilp;
import com.clri.utils.CommonConstants;
import com.clri.utils.CustomMessage;
import com.clri.utils.CustomUtils;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Balamurugan
 */
public class MajorProductionilpServlet extends HttpServlet {

    private Object majorList;

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
        MajorProductionilpDAO majorProductionilpDAO = new MajorProductionilpDAO();
        MajorProductionilp majorProductionilp = new MajorProductionilp();
        HttpSession session = request.getSession();
        if (session.getAttribute("uploadCount") != null) {
            String message = session.getAttribute("uploadCount").toString() + " rows uploaded";
            CustomUtils.setStatus(CommonConstants.SUCCESS_MSG_CODE, message, request);
            session.setAttribute("uploadCount", null);
        }
        if (path.equals(CommonConstants.MAJOR_PRODUCTIONILP_DELETE)) {
            int id = Integer.parseInt(request.getParameter("id"));
            count = majorProductionilpDAO.deleteCategory(id);
            if (count == 0) {
                CustomUtils.setStatus(CommonConstants.ERROR_MSG_CODE, CustomMessage.getMessage("COMMON_DELETE_ERROR"), request);
            } else {
                CustomUtils.setStatus(CommonConstants.SUCCESS_MSG_CODE, CustomMessage.getMessage("COMMON_DELETE_SUCCESS"), request);
            }
        } else if (path.equals(CommonConstants.MAJOR_PRODUCTIONILP_EDIT)) {
            int id = Integer.parseInt(request.getParameter("id"));
            majorProductionilp = majorProductionilpDAO.getById(id);
            request.setAttribute("majorProductions", majorProductionilp);
        } else if(path.equals(CommonConstants.MAJOR_PROD_SAVE_UPDATE)){
            majorProductionilp.setId(CustomUtils.getId(request, "majorId"));
            majorProductionilp.setArticleCode(request.getParameter("articleCode"));
            majorProductionilp.setQuantity(Double.parseDouble(request.getParameter("quantity")));
            count = majorProductionilpDAO.addUpdateRaw(majorProductionilp);
            if (count == 0) {
                CustomUtils.setStatus(CommonConstants.ERROR_MSG_CODE, CustomMessage.getMessage("COMMON_SAVE_ERROR"), request);
            } else {
                CustomUtils.setStatus(CommonConstants.SUCCESS_MSG_CODE, CustomMessage.getMessage("CATEGORY_SAVE_SUCCESS"), request);
            }
        }
        List<MajorProductionilp> majorList = majorProductionilpDAO.getList();
        request.setAttribute("majorList", majorList);
        CustomUtils.setPathName(CommonConstants.MAJOR_PRODUCTIONILP_LIST, request);
        CustomUtils.forward(CommonConstants.MAJOR_PRODUCTIONILP_LIST_JSP, request, response);
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
