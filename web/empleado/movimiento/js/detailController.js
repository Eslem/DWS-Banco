
var app = angular.module("app", []);

app.controller("movimientoDetailController", function ($scope, $http) {
    
    $scope.getMovimiento = function () {
        $http({
            method: "GET",
            url: contextPath + "/api/movimiento/" + $scope.movimiento.id
        }).success(function (data, status) {
            $scope.movimiento = data;
        }).error(function (data, status) {
            alert("Error" + status);
        });


    };

    $scope.insertMovimiento = function () {
        $http({
            method: "POST",
            data: $scope.movimiento,
            url: contextPath + "/api/movimiento/"
        }).success(function (data, status) {
            alert("Movimiento añadido correctamente");
            $scope.getMovimiento($scope.movimiento.id);
        }).error(function (data, status) {
            alert("Error " + status);
        });
    };


    $scope.updateMovimiento = function () {
        $http({
            method: "PUT",
            data: $scope.movimiento,
            url: contextPath + "/api/movimiento/"
        }).success(function (data, status) {
            alert("Movimiento " + $scope.movimiento.id + " actualizado correctamente");
            $scope.getMovimiento($scope.movimiento.id);
        }).error(function (data, status) {
            alert("Error: " + status);
        });
    };


    $scope.deleteMovimiento = function () {
        $http({
            method: "DELETE",
            url: contextPath + "/api/movimiento/" + $scope.movimiento.id
        }).success(function (data, status) {
            alert("Cuenta eleminada correctamente");
            $scope.getMovimiento($scope.movimiento.id);
        }).error(function (data, status) {
            alert("Error " + status);
        });
    };

    $scope.movimiento={};
    $scope.movimiento.id=getURLParameter('id');
    $scope.getMovimiento();
    


});