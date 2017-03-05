<%-- 
    Document   : header
    Created on : Feb 25, 2017, 10:53:15 PM
    Author     : Balamurugan
--%>

<%@page import="com.clri.dto.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String dirName = "static";
    String path = request.getContextPath() + "/" + dirName;
    String userName = "";
    boolean isLoggedIn = false;
    if(request.getSession().getAttribute("user") != null){
        isLoggedIn = true;
        Users user = (Users)request.getSession().getAttribute("user");
        userName = user.getFirstName() + " "+user.getLastName();
    }
%>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->


        <!-- Collect the nav links, forms, and other content for toggling -->

        <div  class="col-sm-12 text-center">
            <div id="logoc" class="clri-logo col-sm-6 pull-left">
                 <% if (isLoggedIn) {%>
                 <a class="menu" href="#menu"></a>
                 <%}%>
                <a href="../<%=request.getContextPath()%>">
                    <img src="<%=path%>/images/crilogo.png">
                    <span id="spnLogoText" class="clri-logo-text">India's Trading Information System for Leather and its Relevant areas</span>
                </a>
            </div>
                     <% if (request.getSession().getAttribute("user") != null) {%>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=userName%> 
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>
                </ul>
            </li>
        </ul>
        <%}%>
        </div>
       
    </div><!-- /.navbar-collapse -->
</div><!-- /.container-fluid -->
</nav>

