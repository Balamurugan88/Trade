/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clri.servlet;

import com.clri.dbutils.DBUtils;
import com.clri.dbutils.DataBaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CDURAI
 */
public class ProductServlet extends HttpServlet {
    private static String TABLE_NAME="products";
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        String contextStr = request.getContextPath();  // "/JavaWebApp"
        String queryStr = request.getQueryString();    // "do=dir"
        String doStr = request.getParameter("do");     // "dir"
        String requestStr = request.getRequestURI();   // "/JavaWebApp/actions"
        String servletPath = request.getServletPath();
        String Status = "";
       

//        System.out.println("===== the context path is == "+contextStr);
//        System.out.println("===== the query string is  == "+queryStr);
//        System.out.println("=== The dostr is ====== "+doStr);
//        System.out.println("====== The request str is ====  "+requestStr);
//        System.out.println("======= The servlet path is ===== "+servletPath);
        String nextPage = null;
        DataBaseConnection dbcon = new DataBaseConnection();
        DBUtils dbUtils=new DBUtils();
        java.sql.Connection con = dbcon.openConnection();
         request.setAttribute("connectionObject", con);
        if (servletPath.equals("/product/List")) {
            nextPage = "/WEB-INF/products/list.jsp";
            request.setAttribute("data", dbUtils.listData(con,TABLE_NAME));

        }
        if (servletPath.equals("/product/Edit")) {
            nextPage = "/WEB-INF/products/edit.jsp";
            String id = request.getParameter("id");
            request.setAttribute("data", dbUtils.editData(con,TABLE_NAME, id));
            //response.sendRedirect(nextPage);
        }
        if (servletPath.equals("/product/Update")) {
            //System.out.println("===== inside update === ");
            nextPage = "/WEB-INF/products/list.jsp";

            Map<String, String[]> mp = request.getParameterMap();
//             System.out.println("===== The map value is ==== "+mp);
            int retVal = dbUtils.updateData(con, mp,TABLE_NAME, new String[]{"id", "code","description"});
            request.setAttribute("data", dbUtils.listData(con,TABLE_NAME));
            if (retVal == 1) {
                Status = "<div style='color:green'>The Data was updated successfully</div>";
            } else {
                Status = "<div style='color:red'>There was a problem while updating</div>";
            }
//             System.out.println("=========== The status is ======== "+Status);
        }
        if (servletPath.equals("/product/Create")) {
            nextPage = "/WEB-INF/products/add.jsp";
        }
        if (servletPath.equals("/product/Delete")) {
            nextPage = "/WEB-INF/products/list.jsp";
            int retVal = dbUtils.deleteData(con,TABLE_NAME, request.getParameter("id"));
            request.setAttribute("data", dbUtils.listData(con,TABLE_NAME));
            if (retVal == 1) {
                Status = "<div style='color:green'>The Data was deleted successfully</div>";
            } else {
                Status = "<div style='color:red'>There was a problem while deleting</div>";
            }
        }
        if (servletPath.equals("/product/Insert")) {
           // System.out.println("===== inside insert === ");
            nextPage = "/WEB-INF/products/list.jsp";

            Map<String, String[]> mp = request.getParameterMap();
//             System.out.println("===== The map value is ==== "+mp);
            int retVal = dbUtils.insertData(con, mp,TABLE_NAME, new String[]{"code","description"});
            request.setAttribute("data", dbUtils.listData(con,TABLE_NAME));
            if (retVal == 1) {
                Status = "<div style='color:green'>The Data was Created successfully</div>";
            } else {
                Status = "<div style='color:red'>There was a problem while Creating</div>";
            }
//             System.out.println("=========== The status is ======== "+Status);
        }
        request.setAttribute("status", Status);
        dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
        //response.sendRedirect(nextPage);
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
