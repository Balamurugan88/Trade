<%-- 
    Document   : js
    Created on : Feb 25, 2017, 10:53:35 PM
    Author     : Balamurugan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String dirName = "static";
    String path = request.getContextPath() + "/" + dirName;
%>
<script type="text/javascript" src="<%=path%>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/datatables.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.mmenu.all.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.datepicker.js"></script>
<script type="text/javascript" src="<%=path%>/js/amcharts.js"></script>
<script type="text/javascript" src="<%=path%>/js/serial.js"></script>
<script type="text/javascript" src="<%=path%>/js/chart.js"></script>
<script type="text/javascript" src="<%=path%>/js/underscore.js"></script>