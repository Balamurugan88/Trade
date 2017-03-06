

<%-- 
    Document   : list
    Created on : Feb 19, 2017, 10:51:07 PM
    Author     : VISALI V
--%>

<%@ page language="java" contentType="text/html;" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer List</title>
    </head>
    <body>
        <div class="col-sm-6 left-column">
            <div class="text-center heading">Customer</div>

            <table id="datatable" class="dataTable display">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Dob</td>
                        <td>Email</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${customerList}" var="customer">
                        <tr>
                            <td><c:out value="${customer.name}"/></td>
                            <td><c:out value="${customer.dob}"/></td>
                            <td><c:out value="${customer.email}"/></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/customer/edit?id=${customer.id}">
                                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                </a>
                                <a href="<%=request.getContextPath()%>/customer/delete?id=${customer.id}"
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
            <%@include file="add.jsp" %>
        </div>
        <script type="text/javascript">
            var currURL = "<%=request.getAttribute("pathName")%>";
            //Push the current URL to window history
            window.history.pushState("object or string", "mapviewer", currURL);

        </script>
    </body>

</html>
