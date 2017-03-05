<%-- 
    Document   : index
    Created on : Feb 20, 2017, 10:14:05 PM
    Author     : VISALI V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


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
<!-- /container -->