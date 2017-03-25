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
            .chart {
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
            <div class="h4">Imports</div>
            <div class="col-sm-6">
                <div class="heading h4 text-center">Customer</div>
                <div class="col-sm-4">
                    <label>Year</label>
                    <select onchange="createCustomerChart(1,true)" id="import-year"></select>
                </div>
                <div class="col-sm-4">
                    <label>Items</label>
                    <select onchange="createCustomerChart(1,true)" id="import-items"></select>
                </div>
                <div id="importchartdiv" class="chart"></div>
            </div>
            <div class="col-sm-6">
                <div class="heading h4 text-center">Production</div>
                <div class="col-sm-4">
                    <label>Year</label>
                    <select onchange="createProdChart(1,true)" id="import-prodYear"></select>
                </div>
                <div class="col-sm-4">
                    <label>Items</label>
                    <select onchange="createProdChart(1,true)" id="import-prodItems"></select>
                </div>
                <div id="importproddiv" class="chart"></div>
            </div>
        </div>
        <div class="row">
            <div class="h4">Exports</div>
            <div class="col-sm-6">
                <div class="heading h4 text-center">Customer</div>
                <div class="col-sm-4">
                    <label>Year</label>
                    <select onchange="createCustomerChart(2,true)" id="export-year"></select>
                </div>
                <div class="col-sm-4">
                    <label>Items</label>
                    <select onchange="createCustomerChart(2,true)" id="export-items"></select>
                </div>
                <div id="exportchartdiv" class="chart"></div>
            </div>
            <div class="col-sm-6">
                <div class="heading h4 text-center">Production</div>
                <div class="col-sm-4">
                    <label>Year</label>
                    <select onchange="createProdChart(2,true)" id="export-prodYear"></select>
                </div>
                <div class="col-sm-4">
                    <label>Items</label>
                    <select onchange="createProdChart(2,true)" id="export-prodItems"></select>
                </div>
                <div id="exportproddiv" class="chart"></div>
            </div>
        </div>        <!-- Chart code -->
        <script type="text/javascript">
            function createCustomerChart(type,isDropDown) {
                var $type= type===1?'import-':'export-';
                var year = $("#"+$type+"year").val();
                var items = $("#"+$type+"items").val();
                if(year !== "-1" && items !== '-1'){
                if(type===1){
                  var customerList = '<%=request.getAttribute("importCustomerList")%>';  
                }else{
                  var customerList = '<%=request.getAttribute("exportCustomerList")%>';   
                }
                
                customerList = JSON.parse(customerList);
                
                var options = {
                    list: customerList,
                    xKey: "country",
                    yKey: "value",
                    xName: "country",
                    yName: "visits",
                    container: $type+"chartdiv",
                    filter: "year",
                    year: year,
                    items: items,
                    itemKey: "items",
                    dropdown: [
                        {"container": $type+"year", "key": "year"},
                        {"container": $type+"items", "key": "items"}
                    ]
                };
                if (isDropDown) {
                    options.createDropDown = false;
                }
                createChart(options);
                }
            }
            function createProdChart(type,isDropDown) {
                 var $type= type===1?'import-':'export-';
                var year = $("#"+$type+"prodYear").val();
                var items = $("#"+$type+"prodItems").val();
                if(year !== '-1' && items !== '-1'){
                if(type === 1){
                var productionList = '<%=request.getAttribute("importProductionList")%>';
            }else{
                var productionList = '<%=request.getAttribute("exportProductionList")%>';
            }
                productionList = JSON.parse(productionList);
                
                var options = {
                    list: productionList,
                    xKey: "items",
                    yKey: "value",
                    xName: "category",
                    yName: "visits",
                    container: $type+"proddiv",
                    filter: "year",
                    year: year,
                    items: items,
                    itemKey: "categoryName",
                    dropdown: [
                        {"container": $type+"prodYear", "key": "year"},
                        {"container": $type+"prodItems", "key": "categoryName"}
                    ]
                };
                if (isDropDown) {
                    options.createDropDown = false;
                }
                createChart(options);
                }
            }
            $(document).ready(function () {
                createCustomerChart(1,false);
                createProdChart(1,false);
                createCustomerChart(2,false);
                createProdChart(2,false);

            });
        </script>
    </body>

</html>
