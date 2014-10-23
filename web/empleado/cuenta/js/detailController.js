var app = angular.module("app", []);

app.controller("detailController", function($scope, $http) {
    
    $scope.cuenta = {};
    $scope.cuenta.id = getURLParameter('id');
    $scope.getCuenta();
    
    $scope.getCuenta = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/cuenta/" + $scope.cuenta.id
        }).success(function(data, status) {
            $scope.cuenta = data;
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.insertCuenta = function() {
        $http({
            method: "POST",
            data: $scope.cuenta,
            url: contextPath + "/api/cuenta/"
        }).success(function(data, status) {
            alert("Cuenta correctamente insertada.");
            $scope.getCuenta($scope.cuenta.id); // Pending
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.updateCuenta = function() {
        $http({
            method: "PUT",
            data: $scope.cuenta,
            url: contextPath + "/api/cuenta/"
        }).success(function(data, status) {
            alert("Cuenta " + $scope.cuenta.id + " correctamente actualizada.");
            $scope.getCuenta($scope.cuenta.id); // Pending
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.deleteCuenta = function() {
        $http({
            method: "DELETE",
            url: contextPath + "/api/cuenta/" + $scope.cuenta.id
        }).success(function() {
            alert("Cuenta " + $scope.cuenta.id + " correctamente borrada.");
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };
});