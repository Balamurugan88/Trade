<%-- 
    Document   : admin-menu
    Created on : Feb 26, 2017, 3:10:22 AM
    Author     : Balamurugan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav id="menu">
    <ul>
        
        <li><a href="<%=request.getContextPath()%>/admin/category/list">Category List</a></li>
        <li><a href="<%=request.getContextPath()%>/admin/customer/list">Customer List </a></li>
        <li>
            <a href="#import">Import </a>
            <ul>
                <li><a>Finished Leather</a>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/import/customers?category=2">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/import/prod?category=2">Major Production with value and year</a></li>
                    </ul>
                </li>
                <li><a>Leather Products</a>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/import/customers?category=3">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/import/prod?category=3">Major Production with value and year</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href="<%=request.getContextPath()%>/majorproductions/">Export</a>
            <ul>
                <li><a>Raw Materials</a>
                    <ul>

                        <li><a href="<%=request.getContextPath()%>/export/customers?category=1">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/export/prod?category=1">Major Production with value and year</a></li>
                    </ul>
                </li>
                <li><a>Finished Leather</a>
                    <ul>


                        <li><a href="<%=request.getContextPath()%>/export/customers?category=2">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/export/prod?category=2">Major Productions with value and year</a></li>
                    </ul>
                </li>
                <li><a>Leather Products</a>
                    <ul>

                        <li><a href="<%=request.getContextPath()%>/export/customers?category=3">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/export/prod?category=3">Major Production with value and year</a></li>
                    </ul>
                </li>
               
            </ul>
        </li>
        <li><a href="<%=request.getContextPath()%>/dashboard">Graphical View</a></li>
    </ul>


</nav>

