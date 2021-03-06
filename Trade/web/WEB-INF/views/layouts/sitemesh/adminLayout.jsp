<%@page import="com.clri.dto.Users"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%
    String userRole = "";
    boolean isLoggedIn = false;
    if (request.getSession().getAttribute("user") != null) {
        isLoggedIn = true;
        Users user = (Users) request.getSession().getAttribute("user");
        userRole = user.getUserRole();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <title> <decorator:title default="Welcome!" /></title>
        <decorator:head />
        <jsp:include page="/WEB-INF/views/layouts/includes/css.jsp"/>
        <jsp:include page="/WEB-INF/views/layouts/includes/js.jsp"/>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <jsp:include page="/WEB-INF/views/layouts/includes/header.jsp"/>
            </div>
            <div id="content">
                <div id="sidemenu" style="width:5px">
                    <% if (userRole.equalsIgnoreCase("admin")) {%>
                    <jsp:include page="/WEB-INF/views/layouts/includes/admin-menu.jsp"/>
                    <%} else {%>
                    <jsp:include page="/WEB-INF/views/layouts/includes/customer-menu.jsp"/>
                    <%}%>
                </div>
                <div id="main" class="container col-sm-11 pull-left">
                    <jsp:include page="/WEB-INF/views/layouts/includes/status.jsp"/>
                    <decorator:body />
                </div>
            </div>
            <div id="footer">
                <jsp:include page="/WEB-INF/views/layouts/includes/footer.jsp"/>
            </div>
        </div>
    </body>
    <script type="text/javascript">
            var currURL = "<%=request.getAttribute("pathName")%>";
           
            //Push the current URL to window history
            window.history.pushState("object or string", "mapviewer", currURL);
        $(document).ready(function () {
            $('#datatable').DataTable();
            $('nav#menu').mmenu({
                extensions: ['effect-slide-menu', 'shadow-page', 'shadow-panels'],
                keyboardNavigation: true,
                screenReader: true,
                counters: true,
                navbar: {
                    title: 'Advanced menu'
                },
                navbars: [
                    {
                        position: 'top',
                        content: ['searchfield']
                    }, {
                        position: 'top',
                        content: [
                            'prev',
                            'title',
                            'close'
                        ]
                    }
                ]
            });
        });
    </script>

</html>
