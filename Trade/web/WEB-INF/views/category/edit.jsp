<%-- 
    Document   : edit
    Created on : Feb 20, 2017, 8:28:47 PM
    Author     : VISALI V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%@include file="/header.jsp" %><br/>
        <% ResultSet rs = (ResultSet) request.getAttribute("data");
            while (rs.next()) {
        %>
        <form name="updateForm" action="<%= request.getContextPath() %>/category/Update" method="post">
        <table>
             <caption><b>Category Edit</b></caption>

            <tr>
                <td>Code</td>
                <td><input type="text" value="<%=rs.getString("code")%>" name="code" /></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" value="<%=rs.getString("description")%>" name="description" /></td>
            </tr>

        </table>
        <%}%>
        <input type="reset" value="Reset"/>
        <input type="submit" value="Save"/>
        </form>
      
</html>
