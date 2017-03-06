<%-- 
    Document   : admin-menu
    Created on : Feb 26, 2017, 3:10:22 AM
    Author     : Balamurugan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav id="menu">
<ul>
<li><a href="<%=request.getContextPath()%>/admin/category/list">Category</a></li>
<li><a href="<%=request.getContextPath()%>/admin/customer/list">Customer</a></li>
<li><a href="<%=request.getContextPath()%>/admin/raw/list">Raw Materials</a></li>
</ul>
</nav>

