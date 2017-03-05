<%-- 
    Document   : add
    Created on : Feb 20, 2017, 8:21:32 PM
    Author     : VISALI V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="/include.jsp" %>
    </head>
    <body>
           <img src="<%=request.getContextPath()%>/images/logo.png" alt="logo" width="100%"/>
        <%--<%@include file="/header.jsp" %><br/>--%>
        <form action="<%=request.getContextPath()%>/customer/Insert" method="post">
            <table>
                 <caption><b>Sign Up</b></caption>
                <tr>
                    <td> User Name:</td>
                    <td><input type="text" value="" name="userName"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" value="" name="password"></td>
                </tr>

                <tr>
                    <td>DOB:</td>
                    <td> <input type="text" value="" name="dob" class="datepicker"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td> <input type="text" value="" name="email"></td>
                </tr>

                <tr><td>
                    <input type="hidden" name="status" value="0"/>
                    </td></tr>
            </table>


            <input type="reset" value="Reset">
            <input type="submit" value="Save">
        </form>

             <%@include file="/footer.jsp" %><br/>
    </body>
</html>
