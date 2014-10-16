var app = angular.module("app", []);

function ControladorEntidad($scope, $http) {
    $scope.getEntidadBancaria = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/entidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
        }).success(function(data, status) {
            $scope.entidadBancaria = data;
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.insertEntidadBancaria = function() {
        $http({
            method: "GET",
            data: $scope.entidadBancaria,
            url: contextPath + "/api/entidadBancaria/"
        }).success(function(data, status) {
            alert("Entidad correctamente insertada.");
            $scope.getEntidadBancaria($scope.entidadBancaria.idEntidadBancaria); // Pending
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
            alert("Entidad " + $scope.entidadBancaria.idEntidadBancaria + " correctamente actualizada.");
            $scope.getEntidadBancaria($scope.entidadBancaria.idEntidadBancaria); // Pending
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.deleteEntidadBancaria = function() {
        $http({
            method: "DELETE",
            url: contextPath + "/api/entidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
        }).success(function() {
            alert("Entidad " + $scope.entidadBancaria.idEntidadBancaria + " correctamente borrada.");
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };
}