app.controller("CuentaNewController", function($scope, $http, $routeParams) {
    $scope.cuenta = {
        
    };


    $scope.insert=function() {
        $http({
            url: contextPath + "/api/cuenta",
            method: "POST",
            data:$scope.cuenta
        }).success(function(data) {
            $scope.cuenta = data;
        }).error(function(data, status) {
            alert("");
        });
    };

});

app.controller("CuentaEditController", function($scope, $http, $routeParams) {
    $scope.cuenta = {
        idCuenta:$routeParams.idCuenta
    };

    $scope.get = function() {
        $http({
            url: contextPath + "/api/cuenta/" + $scope.cuenta.idCuenta,
            method: "GET"
        }).success(function(data) {
            $scope.cuenta = data;

        }).error(function(data, status) {
            alert("");
        });
    };

    $scope.get();

    $scope.update=function() {
        $http({
            url: contextPath + "/api/cuenta/" + $scope.cuenta.idCuenta,
            method: "PUT",
            data:$scope.cuenta
        }).success(function(data) {
            $scope.cuenta = data;
        }).error(function(data, status) {
            alert("");
        });
    };

});

app.controller("CuentaDeleteController", function($scope, $http, $routeParams) {
    $scope.cuenta = {
        
    };


    $scope.delete=function() {
        $http({
            url: contextPath + "/api/cuenta",
            method: "DELETE",
            data:$scope.cuenta
        }).success(function(data) {
            $scope.cuenta = data;
        }).error(function(data, status) {
            alert("");
        });
    };

});






/*var app = angular.module("app", []);

app.controller("CuentaDetailController", function($scope, $http) {
    
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
});*/