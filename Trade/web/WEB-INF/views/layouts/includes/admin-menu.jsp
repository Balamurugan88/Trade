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
        <li>
            <a href="#import">Import</a>
            <ul>
                <li><a>Leather</a></li>
                <li><a href="<%=request.getContextPath()%>/admin/raw/list">Raw Materials</a>
                    <ul>
                        <li><a>Major Customers</a></li>
                        <li><a>Major Productions</a></li>
                    </ul>
                </li>
                
            </ul>

        </li>
        <li><a href="<%=request.getContextPath()%>/admin/raw/">Export</a>
            <ul>
                <li><a>Leather Products</a>
                    <ul>
                        <li><a>Major Customer</a></li>
                        <li><a>Major Supplies</a></li>
                        <li><a>Major Productions</a></li>
                    </ul>
                </li>
                <li><a>Finished Leather</a>
                <ul>
                        <li><a>Major Customer</a></li>
                        <li><a>Major Supplies</a></li>
                        <li><a>Major Productions</a></li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>

   
</nav>

