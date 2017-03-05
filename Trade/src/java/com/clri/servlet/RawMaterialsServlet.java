/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.servlet;

import com.clri.dao.RawMaterialsDAO;
import com.clri.dto.RawMaterials;
import com.clri.utils.CommonConstants;
import com.clri.utils.CustomMessage;
import com.clri.utils.CustomUtils;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "RawMaterials", urlPatterns = {"/raw"})
public class RawMaterialsServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        RawMaterialsDAO rawMaterialsDAO = new RawMaterialsDAO();
        RawMaterials rawMaterials = new RawMaterials();
        if (path.equals(CommonConstants.RAW_SAVE_UPDATE)) {
            rawMaterials.setId(CustomUtils.getId(request,"rawId"));
            rawMaterials.setArticleCode(request.getParameter("articleCode"));
            rawMaterials.setQuantity(Double.parseDouble(request.getParameter("quantity")));
            int count = rawMaterialsDAO.addUpdateRaw(rawMaterials);
            if (count == 0) {
                CustomUtils.setStatus(CommonConstants.ERROR_MSG_CODE, CustomMessage.getMessage("CATEGORY_SAVE_ERROR"), request);
            } else {
                CustomUtils.setStatus(CommonConstants.SUCCESS_MSG_CODE, CustomMessage.getMessage("CATEGORY_SAVE_SUCCESS"), request);
            }
        } else if (path.equals(CommonConstants.CATEGORY_DELETE)) {
            int id = Integer.parseInt(request.getParameter("id"));
            rawMaterialsDAO.deleteCategory(id);
        } else if (path.equals(CommonConstants.CATEGORY_EDIT)) {
            int id = Integer.parseInt(request.getParameter("id"));
            rawMaterials = rawMaterialsDAO.getById(id);
            request.setAttribute("rawMaterials", rawMaterials);
        }
        List<RawMaterials> rawList = rawMaterialsDAO.getList();
        request.setAttribute("rawList", rawList);
        CustomUtils.setPathName(CommonConstants.RAW_LIST, request);
        CustomUtils.forward(CommonConstants.RAW_LIST_JSP, request, response);
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
