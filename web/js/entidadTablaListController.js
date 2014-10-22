var app = angular.module("app", []);

function EntidadTablaListController($scope, $http) {    
    $http({
        method: "GET",
        url: contextPath + "/api/entidadBancaria/"
    }).success(function(data, status) {
        $scope.entidadesBancarias = data;
    }).error(function(data, status) {
        alert("Fatal error: " + status);
    });
}