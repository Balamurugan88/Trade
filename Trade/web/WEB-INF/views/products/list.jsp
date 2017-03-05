package WEB-INF.products;

<%-- 
    Document   : list
    Created on : Dec 17, 2011, 11:06:44 AM
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
        <script type="text/javascript">
            function deleteVal(id){
                var conf = confirm("Are you sure you want to delete this ?");
                if(conf == true){
                    location.href="<%= request.getContextPath()%>/product/Delete?id="+id
                }else{
                    return false;
                }

            }
        </script>
    </head>
    <body>
         <%@include file="/header.jsp" %><br/>
       <%String status = (String) request.getAttribute("status");%>
        <div id="status"><%=status%></div>
        <table border="1">
             <caption><b>Products List</b></caption>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <% ResultSet rs = (ResultSet) request.getAttribute("data");
               while (rs.next()) {
                    %>
                    <tr>
                        <td><%=rs.getString("id")%></td>
                        <td><%=rs.getString("code")%></td>
                        <td><%=rs.getString("description")%></td>
                        <td><a href="#" onClick="location.href='<%= request.getContextPath()%>/product/Edit?id=<%=rs.getString("id")%>'">Edit</a>
                       <a href="#" onClick="deleteVal('<%=rs.getString("id")%>');">Delete</a></td>

                    </tr>
                    <% }%>
                </tbody>
            </table>
        <a href="<%=request.getContextPath()%>/product/Create">Create new Product</a>
      
    </body>
</html>
