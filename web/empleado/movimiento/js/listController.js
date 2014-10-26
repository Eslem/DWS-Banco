
var app = angular.module("app", []);

app.controller("movimientoListController", function ($scope, $http) {
   
    $scope.findAll = function (id) {
        $http({
            method: "GET",
            url: contextPath + "/api/movimiento/"
        }).success(function(data,status){
            $scope.movimientos= data;
        }).error(function(data,status){
            alert("Error "+status);
        });
    };
    
     $scope.deleteMovimiento = function(id) {
        $http({
            method: "DELETE",
            url: contextPath + "/api/movimiento/" + id
        }).success(function() {
            $scope.findAll();
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };
    
     $scope.abrirDetail = function(id) {
        window.open(contextPath + "/empleado/movimiento/detail.html?id=" + id);
    };

    $scope.findAll();
});