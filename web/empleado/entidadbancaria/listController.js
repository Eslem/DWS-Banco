var app = angular.module("app", []);

app.controller("EntidadTablaListController", function($scope, $http) {
    $scope.launchApi = function(id) {
        window.open(contextPath + "/empleado/entidadbancaria/detail.html?id=" + id);
    };
    
    $scope.deleteEntidadBancaria = function(id) {
        $http({
            method: "DELETE",
            url: contextPath + "/api/entidadBancaria/" + id
        }).success(function() {
            alert("Entidad " + id + " correctamente borrada.");
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });        
    };


    /* Código de ejecución */

    $http({
        method: "GET",
        url: contextPath + "/api/entidadBancaria/"
    }).success(function(data, status) {
        $scope.entidadesBancarias = data;
    }).error(function(data, status) {
        alert("Fatal error: " + status);
    });
});