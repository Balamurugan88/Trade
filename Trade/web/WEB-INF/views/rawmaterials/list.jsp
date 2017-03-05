<%-- 
    Document   : list
    Created on : Feb 19, 2017, 8:29:25 PM
    Author     : VISALI V
--%>

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
                <form method="post" action="<%=request.getContextPath()%>/ExcelUpload" enctype="multipart/form-data">
                    <div class="input-group pull-left col-sm-offset-6 col-sm-6">
                        <input type="file" name="file" class="form-control" placeholder="Upload File">
                    </div>
                    <input type="submit" class="btn btn-primary col-sm-offset-8 col-sm4" value="Submit"/>
                </form>
                <table id="datatable" class="dataTable display">
                    <thead>
                        <tr>
                            <td>Article Code</td>
                            <td>Category</td>
                            <td>Sub-Category</td>
                            <td>Price(Rs)</td>
                            <td>Quantity(Kg)</td>
                            <td>Year</td>
                            <td>Action</td>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${rawList}" var="raw">
                        <tr>
                            <td><c:out value="${raw.articleCode}"/></td>
                            <td><c:out value="${raw.category}"/></td>
                            <td><c:out value="${raw.subCategory}"/></td>
                        <td><c:out value="${raw.value}"/></td>
                        <td><c:out value="${raw.quantity}"/></td>
                        <td><c:out value="${raw.year}"/></td>
                        <td>
                            <a href="<%=request.getContextPath()%>/raw/edit?id=${raw.id}">
                                <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                            </a>
                            <a href="<%=request.getContextPath()%>/raw/delete?id=${raw.id}"
                               onclick="return confirm('Are you sure you want to delete this item?')";>
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>

                            </a>
                        </td>
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
