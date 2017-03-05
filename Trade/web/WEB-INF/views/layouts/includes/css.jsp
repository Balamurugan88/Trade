<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String dirName = "static";
    String path = request.getContextPath() + "/" + dirName;
%>

<link rel="shortcut icon" type="image/x-icon" href="<%=path%>/images/favicon.ico" />
<link rel="icon" type="image/x-icon" href="<%=path%>/images/favicon.ico" />
<link rel="apple-touch-icon" href="<%=path%>/images/favicon.ico" />

<link rel="stylesheet" type="text/css" href="<%=path%>/css/datatables.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/jquery.mmenu.all.css" />
