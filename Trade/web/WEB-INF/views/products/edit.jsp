package WEB-INF.products;

<%-- 
    Document   : edit
    Created on : Dec 17, 2011, 11:06:36 AM
    Author     : CDURAI
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
        <form name="updateForm" action="<%= request.getContextPath() %>/product/Update" method="post">
        <table>
             <caption><b>Products Edit</b></caption>
            <tr>
                <td>Id</td>
                <td><input type="text" readonly name="id" value="<%=rs.getString("id")%>"/></td>
            </tr>
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
