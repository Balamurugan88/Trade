<%-- 
    Document   : index
    Created on : Feb 20, 2017, 10:14:05 PM
    Author     : VISALI V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.clri.dto.Users"%>
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
<html>
    <head>
        <link rel="shortcut icon" type="image/x-icon" href="<%=path%>/images/favicon.ico" />
<link rel="icon" type="image/x-icon" href="<%=path%>/images/favicon.ico" />
<link rel="apple-touch-icon" href="<%=path%>/images/favicon.ico" />

<link rel="stylesheet" type="text/css" href="<%=path%>/css/datatables.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/jquery.mmenu.all.css" />
        <title>Login Page</title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->


        <!-- Collect the nav links, forms, and other content for toggling -->

        <div  class="col-sm-12 text-center">
            <div id="logoc" class="clri-logo col-sm-8 pull-left">
                
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
<div >
    <div class="col-sm-8">

    </div>
    <div class="col-sm-4">
        <form class="form-signin" method="post" action="<%=request.getContextPath()%>/LoginAuthenticate">
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="text" id="inputEmail" name="username" class="form-control" placeholder="User Name" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>

   
</div>
    </body>
</html>

<!-- /container -->