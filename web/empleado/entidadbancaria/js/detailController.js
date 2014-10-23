var app = angular.module("app", []);

app.controller("EntidadTablaDetailController", function($scope, $http) {
    $scope.getEntidadBancaria = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/entidadBancaria/" + $scope.entidadBancaria.id
        }).success(function(data, status) {
            $scope.entidadBancaria = data;
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.insertEntidadBancaria = function() {
        $http({
            method: "POST",
            data: $scope.entidadBancaria,
            url: contextPath + "/api/entidadBancaria/"
        }).success(function(data, status) {
            alert("Entidad correctamente insertada.");
            $scope.getEntidadBancaria($scope.entidadBancaria.id); // Pending
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.updateEntidadBancaria = function() {
        $http({
            method: "PUT",
            data: $scope.entidadBancaria,
            url: contextPath + "/api/entidadBancaria/"
        }).success(function(data, status) {
            alert("Entidad " + $scope.entidadBancaria.id + " correctamente actualizada.");
            $scope.getEntidadBancaria($scope.entidadBancaria.id); // Pending
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.deleteEntidadBancaria = function() {
        $http({
            method: "DELETE",
            url: contextPath + "/api/entidadBancaria/" + $scope.entidadBancaria.id
        }).success(function() {
            alert("Entidad " + $scope.entidadBancaria.id + " correctamente borrada.");
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };


    /* Código de ejecución */

    $scope.entidadBancaria = {};
    $scope.entidadBancaria.id = getURLParameter('id');
    $scope.getEntidadBancaria();
});