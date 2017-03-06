<%-- 
    Document   : edit
    Created on : Feb 20, 2017, 8:26:54 PM
    Author     : VISALI V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Connection"%>
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

        <form name="updateForm" action="<%= request.getContextPath() %>/customer/Update" id="formId" method="post">
        <table>
             <caption><b>Customers Edit</b></caption>
            <tr>
                <td>Id</td>
                <td><input type="text" readonly name="id" value="<%=rs.getString("id")%>"/></td>
            </tr>
            <tr>
                <td>UserName</td>
                <td><input type="text" class="required" value="<%=rs.getString("userName")%>" name="userName" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" value="<%=rs.getString("password")%>" name="password" /></td>
            </tr>

            <tr>
                <td>DOB</td>
                <td><input type="text" value="<%=rs.getString("dob")%>" id="datepicker" class="datepicker" name="dob" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" value="<%=rs.getString("email")%>" name="email" /></td>
            </tr>
            <tr>
                <td>Type</td>
                <td>
                     <% String businessSel="",homeSel="";
                     if(rs.getString("type").equals("1")){
                      businessSel="selected";
                     }else{
                         homeSel="selected";
                     }%>
                   
                </td>
            </tr>

        </table>
        <%}%>
        <input type="reset" value="Reset"/>
        <input type="submit" value="Save"/>
        </form>
         <% Connection con=(Connection)request.getAttribute("connectionObject");
                        con.close();
                    %>
         <%@include file="/footer.jsp" %><br/>
</html>
