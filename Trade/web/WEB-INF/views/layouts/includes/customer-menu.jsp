<%-- 
    Document   : admin-menu
    Created on : Feb 26, 2017, 3:10:22 AM
    Author     : Balamurugan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav id="menu">
    <ul>
        <li><a href="<%=request.getContextPath()%>/dashboard">Dashboard</a></li>
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

                        <li><a href="<%=request.getContextPath()%>/import/customers">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/import/prod">Major Production with value and year</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href="<%=request.getContextPath()%>/majorproductions/">Export</a>
            <ul>
                <li><a>Raw Materials</a>
                    <ul>

                        <li><a href="<%=request.getContextPath()%>/majorcustomer/list">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/majorproductions/list">Major Production with value and year</a></li>
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

                        <li><a href="<%=request.getContextPath()%>/majorcustomerelp/">Major Customers</a></li>
                        <li><a href="<%=request.getContextPath()%>/majorproductionelp/">Major Production with value and year</a></li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>


</nav>

