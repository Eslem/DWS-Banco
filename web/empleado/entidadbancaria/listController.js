var app = angular.module("app", []);

function EntidadTablaListController($scope, $http) {
    $scope.launchApi = function(id) {
        window.open(contextPath + "/empleado/entidadbancaria/detail.html?id=" + id);
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
}