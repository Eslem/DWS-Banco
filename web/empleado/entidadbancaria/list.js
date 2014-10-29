app.controller("EntidadBancariaListController", function($scope, $http) {
    $scope.findAll = function(id) {
        $http({
            method: "GET",
            url: contextPath + "/api/entidadBancaria/"
        }).success(function(data, status) {
            $scope.entidadesBancarias = data;
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.deleteEntidadBancaria = function(id) {
        $http({
            method: "DELETE",
            url: contextPath + "/api/entidadBancaria/" + id
        }).success(function() {
            $scope.findAll();
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };


    /* Código de ejecución */
    $scope.findAll();
});