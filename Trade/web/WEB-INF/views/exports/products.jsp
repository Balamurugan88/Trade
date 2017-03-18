<%-- 
    Document   : list
    Created on : Feb 19, 2017, 8:29:25 PM
    Author     : VISALI V
--%>

<%@page import="com.clri.utils.CustomUtils"%>
<%@ page language="java" contentType="text/html;" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-sm-12">
            <div class="col-sm-12">
                 <%if(CustomUtils.isAdmin(request)){%>
                <form method="post" action="<%=request.getContextPath()%>/admin/ExcelUpload?uploadType=production&type=2&category=<%=request.getParameter("category")%>" enctype="multipart/form-data">
                    <div class="input-group pull-left col-sm-offset-6 col-sm-6">
                        <input type="file" name="file" class="form-control" placeholder="Upload File">
                    </div>
                    <input type="submit" class="btn btn-primary col-sm-offset-8 col-sm4" value="Submit"/>
                </form>
                      <%}%>
                <table id="datatable" class="dataTable display">
                    <thead>
                        <tr>
                            <td>Article Code</td>
                            <td>Items</td>
                            <td>Quantity</td>
                            <td>Value</td>
                            <td>Year</td>
                             <%if(CustomUtils.isAdmin(request)){%>
                            <td>Action</td>
                              <%}%>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${prodList}" var="prod">
                            <tr>
                                <td><c:out value="${prod.articleCode}"/></td>
                                <td><c:out value="${prod.items}"/></td>
                                <td><c:out value="${prod.value}"/></td>
                                <td><c:out value="${prod.quantity}"/></td>
                                <td><c:out value="${prod.year}"/></td>
                                 <%if(CustomUtils.isAdmin(request)){%>
                                <td>
                                   
                                    <a href="<%=request.getContextPath()%>/admin/export/delete?id=${prod.id}&type=production&category=<%=request.getParameter("category")%>"
                                       onclick="return confirm('Are you sure you want to delete this item?')";>
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>

                                    </a>
                                </td>
                                  <%}%>
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
            </div>

            <div class="col-sm-6">

            </div>

        </div>

    </body>
</html>
