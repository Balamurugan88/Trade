package WEB-INF.products;

<%-- 
    Document   : add
    Created on : Dec 17, 2011, 11:06:10 AM
    Author     : CDURAI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%@include file="/header.jsp" %><br/>
        <form action="<%=request.getContextPath()%>/product/Insert" method="post">
            <table>
                 <caption><b>Products Add</b></caption>
                <tr>
                    <td>Product Code:</td>
                    <td> <input type="text" value="" name="code"></td>
                </tr>
                <tr>
                    <td>Product Description:</td>
                    <td><input type="text" value="" name="description"></td>
                </tr>
            </table>
            <input type="reset" value="Reset">
            <input type="submit" value="Save">
        </form>
            
    </body>
</html>
