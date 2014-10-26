
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
            $scope.getMovimiento($scope.movimiento.id);
        }).error(function (data, status) {
            alert("NO funciona" + status);
        });
    };


    $scope.updateMovimiento = function () {
        $http({
            method: "PUT",
            data: $scope.movimiento,
            url: contextPath + "/api/movimiento/"
        }).success(function (data,status) {
            alert("Movimiento "+$scope.movimiento.id+" actualizado correctamente");
            $scope.getMovimiento($scope.movimiento.id);

        }).error(function (data, status) {
            alert("Fatal error: " + status);
        });
    };

});