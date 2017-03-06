/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.servlet;

import com.clri.dao.CustomerDAO;
import com.clri.dto.Customer;
import com.clri.utils.CommonConstants;
import com.clri.utils.CustomMessage;
import com.clri.utils.CustomUtils;
import java.io.IOException;
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
public class CustomerServlet extends HttpServlet {

    private Object customerList;

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
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = new Customer();
        int count = 0;
        //}
        if (path.equals(CommonConstants.CUSTOMER_SAVE_UPDATE)) {
            customer.setId(CustomUtils.getId(request, "id"));
            customer.setName(request.getParameter("name"));
            customer.setDob(request.getParameter("dob"));
            customer.setEmail(request.getParameter("email"));
            count = customerDAO.addUpdateCustomer(customer);
            if (count == 0) {
                CustomUtils.setStatus(CommonConstants.ERROR_MSG_CODE, CustomMessage.getMessage("COMMON_SAVE_ERROR"), request);
            } else {
                CustomUtils.setStatus(CommonConstants.SUCCESS_MSG_CODE, CustomMessage.getMessage("CUSTOMER_SAVE_SUCCESS"), request);
            }
        } else if (path.equals(CommonConstants.CUSTOMER_DELETE)) {
            int id = Integer.parseInt(request.getParameter("id"));
            count = customerDAO.deleteCustomer(id);
            if (count == 0) {
                CustomUtils.setStatus(CommonConstants.ERROR_MSG_CODE, CustomMessage.getMessage("COMMON_DELETE_ERROR"), request);
            } else {
                CustomUtils.setStatus(CommonConstants.SUCCESS_MSG_CODE, CustomMessage.getMessage("CUSTOMER_DELETE_SUCCESS"), request);
            }
        } else if (path.equals(CommonConstants.CUSTOMER_EDIT)) {
            int id = Integer.parseInt(request.getParameter("id"));
            customer = customerDAO.getById(id);
            request.setAttribute("customer", customer);
        }
        List<Customer> customerlist = (List<Customer>) customerDAO.getList();
        request.setAttribute("customerList", customerlist);
        CustomUtils.setPathName(CommonConstants.CUSTOMER_LIST, request);
        CustomUtils.forward(CommonConstants.CUSTOMER_LIST_JSP, request, response);

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
