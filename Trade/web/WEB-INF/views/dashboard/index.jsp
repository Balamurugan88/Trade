<%-- 
    Document   : index.jsp
    Created on : Mar 12, 2017, 4:00:12 PM
    Author     : Balamurugan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            #chartdiv,#proddiv {
                width: 100%;
                height: 400px;
            }
            select{
                width:150px;
                padding-left:20px;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
        <!-- HTML -->
        <div class="row">
            <div class="col-sm-6">
                <div class="heading h4 text-center">Customer</div>
                <div class="col-sm-4">
                    <label>Year</label>
                    <select onchange="createCustomerChart(1)" id="year"></select>
                </div>
                <div class="col-sm-4">
                    <label>Items</label>
                    <select onchange="createCustomerChart(1)" id="items"></select>
                </div>
                <div id="chartdiv"></div>
            </div>
            <div class="col-sm-6">
                <div class="heading h4 text-center">Production</div>
                 <div class="col-sm-4">
                    <label>Year</label>
                    <select onchange="createProdChart(1)" id="prodYear"></select>
                </div>
                <div class="col-sm-4">
                    <label>Items</label>
                    <select onchange="createProdChart(1)" id="prodItems"></select>
                </div>
                <div id="proddiv"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">

            </div>
            <div class="col-sm-6"></div>
        </div>
        <!-- Chart code -->
        <script type="text/javascript">
            function createCustomerChart(type) {
                var year = $("#year").val();
                var items =$("#items").val();
                var customerList = '<%=request.getAttribute("customerList")%>';
                customerList = JSON.parse(customerList);
                if ($.trim(year) === '') {
                    year = customerList[0].year;
                }
                 if ($.trim(items) === '') {
                    items = customerList[0].items;
                }
                var options = {
                    list: customerList,
                    xKey: "country",
                    yKey: "quantity",
                    xName: "country",
                    yName: "visits",
                    container: "chartdiv",
                    filter: "year",
                    year :year,
                    items:items,
                    dropdown: [
                        {"container": "year", "key": "year"},
                        {"container": "items", "key": "items"}
                    ]
                };
                if(type === 1){
                    options.createDropDown =false;
                }
                createChart(options);
            }
            function createProdChart(type) {
                var year = $("#prodYear").val();
                var items =$("#prodItems").val();
                var productionList = '<%=request.getAttribute("productionList")%>';
                productionList = JSON.parse(productionList);
                if ($.trim(year) === '') {
                    year = productionList[0].year;
                }
                 if ($.trim(items) === '') {
                    items = productionList[0].items;
                }
                var options = {
                    list: productionList,
                    xKey: "country",
                    yKey: "quantity",
                    xName: "country",
                    yName: "visits",
                    container: "proddiv",
                    filter: "year",
                    year :year,
                    items:items,
                    itemKey :"articleCode",
                    dropdown: [
                        {"container": "prodYear", "key": "year"},
                        {"container": "prodItems", "key": "articleCode"}
                    ]
                };
                if(type === 1){
                    options.createDropDown =false;
                }
                createChart(options);
            }
            $(document).ready(function () {
                createCustomerChart();
               // createProdChart();

            });
        </script>
    </body>

</html>
