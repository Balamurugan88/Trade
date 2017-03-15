<%-- 
    Document   : FinishedLeather
    Created on : Mar 15, 2017, 7:49:36 PM
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
                <form method="post" action="<%=request.getContextPath()%>/admin/ExcelUpload?uploadType=finished_leather&category=4" enctype="multipart/form-data">
                    <div class="input-group pull-left col-sm-offset-6 col-sm-6">
                        <input type="file" name="file" class="form-control" placeholder="Upload File">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>