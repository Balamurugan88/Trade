<%-- 
    Document   : admin-menu
    Created on : Feb 26, 2017, 3:10:22 AM
    Author     : Balamurugan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav id="menu">
    <ul>
        <li><a href="<%=request.getContextPath()%>/admin/dashboard">Dashboard</a></li>
        <li><a href="<%=request.getContextPath()%>/admin/category/list">Category List</a></li>
        <li><a href="<%=request.getContextPath()%>/admin/customer/list">Customer List </a></li>
        <li>
            <a href="#import">Import </a>
            <ul>
                <li><a>Finished Leather</a>
                    <ul>

                        <li><a>Major Customers</a></li>
                        <li><a>Major Production with value and year</a></li>
                    </ul>
                </li>
                <li><a>Leather Products</a>
                    <ul>

                        <li><a href="<%=request.getContextPath()%>/admin/import/customers">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/admin/import/prod">Major Production with value and year</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href="<%=request.getContextPath()%>/admin/majorproductions/">Export</a>
            <ul>
                <li><a>Raw Materials</a>
                    <ul>

                        <li><a href="<%=request.getContextPath()%>/admin/majorcustomer/list">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/admin/majorproductions/list">Major Production with value and year</a></li>
                    </ul>
                </li>
                <li><a>Finished Leather</a>
                    <ul>


                        <li><a>Major Customers</a></li>
                        <li><a>Major Productions with value and year</a></li>
                    </ul>
                </li>
                <li><a>Leather Products</a>
                    <ul>

                        <li><a href="<%=request.getContextPath()%>/admin/majorcustomerilp/">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/admin/majorproductionilp/">Major Production with value and year</a></li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>


</nav>

