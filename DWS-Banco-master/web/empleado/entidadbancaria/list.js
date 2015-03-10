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

    $scope.create = function() {
        location.replace('#/entidadbancaria/insert/');
    };

    $scope.edit = function(id) {
        location.replace('#/entidadbancaria/update/' + id);
    };

    $scope.deleteEntidadBancaria = function(entidadBancaria) {
        if (confirm('¿Confirma usted el borrado de la Entidad Bancaria "' + entidadBancaria.nombre + '"?')) {
            $http({
                method: "DELETE",
                url: contextPath + "/api/entidadBancaria/" + entidadBancaria.id
            }).success(function() {
                $scope.findAll();
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        }
    };


    /* Código de ejecución */
    $scope.findAll();
});