
app.controller("MovimientoListController", function ($scope, $http) {
    $scope.findAll = function (id) {
        $http({
            method: "GET",
            url: contextPath + "/api/movimiento/"
        }).success(function (data, status) {
            $scope.movimientos = data;
        }).error(function (data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.deleteMovimiento = function (id) {
        ok = confirm("¿ Estas seguro que quieres borrar el movimiento con ID: " + id+" ?");
        if (ok) {
            $http({
                method: "DELETE",
                url: contextPath + "/api/movimiento/" + id
            }).success(function () {
                alert("Exito al borrar el movimiento con ID: "+id);
                $scope.findAll();
            }).error(function (data, status) {
                alert("Fatal error: " + status);
            });
        }else{
            $scope.findAll();
        }   

    };

    $scope.crear=function(){
      location.replace("#/movimiento/insert/");
    };

    $scope.editar = function (id) {
        location.replace('#/movimiento/update/' + id);
    };

    $scope.findAll();
});





/*
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
 });*/