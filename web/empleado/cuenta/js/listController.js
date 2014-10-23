var app = angular.module("app", []);

app.controller("listController", function($scope, $http) {
    
    $scope.findAll();
    
    $scope.findAll = function(id) {
        $http({
            method: "GET",
            url: contextPath + "/api/cuenta/"
        }).success(function(data, status) {
            $scope.cuentas = data;
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.deleteCuenta = function(id) {
        $http({
            method: "DELETE",
            url: contextPath + "/api/cuenta/" + id
        }).success(function() {
            $scope.findAll();
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };
    $scope.launchApi = function(id) {
        window.open(contextPath + "/empleado/cuenta/detail.html?id=" + id);
    };

});