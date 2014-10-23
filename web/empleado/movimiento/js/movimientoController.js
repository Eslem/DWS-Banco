
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
            alert("funciona" + data);
        }).error(function (data, status) {
            alert("NO funciona"+ status);
        });
    };

});