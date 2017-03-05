<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <body> 
        <%
            String statusMsg = "";
            String statusCode = "";
            if (request.getAttribute("statusMessage") != null) {
                statusMsg = request.getAttribute("statusMessage").toString();
                statusCode = request.getAttribute("statusCode").toString();
            }
           
        %>
        <div class="status-msg alert alert-<%=statusCode%>"><%=statusMsg%></div>
    </body>
</html>