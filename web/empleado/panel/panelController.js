/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function charts() {
    var dark = '#242A30',
            dark1 = '2D353C';

    new Morris.Line({
        // ID of the element in which to draw the chart.
        element: 'chart-productos',
        data: [{
                y: '2010',
                a: 34,
                b: 54,
                c: 12,
                d: 23,
                e: 13
            }, {
                y: '2011',
                a: 64,
                b: 23,
                c: 46,
                d: 23,
                e: 56
            }, {
                y: '2012',
                a: 32,
                b: 43,
                c: 62,
                d: 2,
                e: 32
            }, {
                y: '2013',
                a: 65,
                b: 3,
                c: 23,
                d: 53,
                e: 23
            }, {
                y: '2014',
                a: 21,
                b: 23,
                c: 45,
                d: 54,
                e: 75
            }],
        xkey: 'y',
        ykeys: ['a', 'b', 'c', 'd', 'e'],
        labels: ['Producto A', 'Producto B', 'Producto C', 'Producto D', 'Producto E'],
        gridLineColor: "rgba(0,0,0,0.5)",
    });


    Morris.Donut({
        element: 'chart-productos2',
        data: [{
                label: "Nuevas visitas",
                value: 56
            }, {
                label: "Visitas Recurrentes",
                value: 44
            }],
        labelColor: '#777777',
        colors: ['#348FE2', '#00ACAC'],
        backgroundColor: dark,
        labels: ['Nuevas visitas', 'Visitas Recurrentes']

    });

    jQuery('#vmap').vectorMap({
        map: 'world_en',
        backgroundColor: null,
        color: '#ffffff',
        hoverOpacity: 0.7,
        selectedColor: '#666666',
        enableZoom: true,
        showTooltip: true,
        values: sample_data,
        scaleColors: ['#C8EEFF', '#006491'],
        normalizeFunction: 'polynomial'
    });

}


app.controller("PanelController", ['$scope', '$rootScope', PanelController]);


function PanelController($scope, $rootScope, LoginService) {
    charts();
}