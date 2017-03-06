

<%-- 
    Document   : list
    Created on : Feb 19, 2017, 8:29:25 PM
    Author     : VISALI V
--%>

<%@ page language="java" contentType="text/html;" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category List</title>
    </head>
    <body>
        <div class="col-sm-6 left-column">
            <div class="text-center heading">Category</div>
            
            <table id="datatable" class="dataTable display">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${categoryList}" var="category">
                        <tr>
                            <td><c:out value="${category.name}"/></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/category/edit?articleCode=${category.articleCode}">
                                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                </a>
                                <a href="<%=request.getContextPath()%>/category/delete?articleCode=${category.articleCode}"
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
