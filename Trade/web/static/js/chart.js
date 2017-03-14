/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var createDropDown = function (list, value) {
    var $container = $("#" + value.container);
    $container.html("");
    $.each(list, function (index, value) {
        $container.append($('<option>', {
            value: value,
            text: value
        }));
    });
};
var createChart = function (options) {
    var dataProvider = [];
    options = options || {};
    if(options.createDropDown !== false){
    $.each(options.dropdown, function (index, value) {
        var list = _.pluck(options.list, value.key);
        list = _.uniq(list);
        createDropDown(list, value);
    });
}
    $.each(options.list, function (index, value) {
        if (options.year === value[options.filter] &&
               options.items === value[options.itemKey] ) {
            var dataObj = {};
            dataObj[options.xName] = value[options.xKey];
            dataObj[options.yName] = Number(value[options.yKey]);
            dataProvider.push(dataObj);
        }
    });
    var chart = AmCharts.makeChart(options.container, {
        "theme": "light",
        "type": "serial",
        "startDuration": 2,
        "dataProvider": dataProvider,
        "depth3D": 20,
        "angle": 30,
        "valueAxes": [{
                "position": "left",
                "title": "Quantity"
            }],
        "graphs": [{
                "balloonText": "[[category]]: <b>[[value]]</b>",
                "fillColorsField": "color",
                "fillAlphas": 1,
                "lineAlpha": 0.1,
                "type": "column",
                "valueField": options.yName
            }],
        "chartCursor": {
            "categoryBalloonEnabled": false,
            "cursorAlpha": 0,
            "zoomable": false
        },
        "categoryField": options.xName,
        "categoryAxis": {
            "gridPosition": "start",
            "labelRotation": 90
        }


    });
};

