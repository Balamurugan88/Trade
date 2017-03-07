<%-- 
    Document   : admin-menu
    Created on : Feb 26, 2017, 3:10:22 AM
    Author     : Balamurugan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav id="menu">
     <li>
            <a href="#import">Import</a>
             <li><a>Finished Leather</a>
                <ul>
                         <li><a>List of Finished Leather</a></li>
                        <li><a>Major Customers</a></li>
                        <li><a>Major Suppliers</a></li>
                        <li><a>Major Productions with value and year</a></li>
                    </ul>
                </li>
                <li><a>Leather Products</a>
                
                    <ul>
                        <li><a>List of Leather Products</a></li>
                        <li><a>Major Customers</a></li>
                        <li><a>Major Suppliers</a></li>
                        <li><a>Major Productions with value and year</a></li>
                    </ul>
                </li>
                
            

        </li>
        <li><a href="<%=request.getContextPath()%>/admin/rm/">Export</a>
             <li><a>Raw Materials</a>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/admin/items/list">List of Raw Materials</a></li>
                        <li><a href="<%=request.getContextPath()%>/admin/raw/list">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/admin/major/list">Major Productions</a></li>
                    </ul>
                </li>
            <ul>
                <li><a>Finished Leather</a>
                    <ul>
                        <li><a>List of Finished Leather</a></li>
                        <li><a>Major Customers</a></li>
                        <li><a>Major Suppliers</a></li>
                        <li><a>Major Productions with value and year</a></li>
                    </ul>
                </li>
                <li><a>Leather Products</a>
                <ul>
                    <li><a>List of Leather Products</a></li>
                        <li><a>Major Customers</a></li>
                        <li><a>Major Suppliers</a></li>
                        <li><a>Major Productions with value and year</a></li>
                    </ul>
                </li>
            </ul>
       
</nav>
    