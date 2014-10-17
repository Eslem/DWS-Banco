var app = angular.module("app", []);

function ControladorCuenta($scope, $http) {
    $scope.getCuenta = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/cuentas/" + $scope.Cuenta.idCuenta
        }).success(function(data, status) {
            $scope.Cuenta = data;
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.insertCuenta = function() {
        $http({
            method: "GET",
            data: $scope.Cuenta,
            url: contextPath + "/api/cuentas/"
        }).success(function(data, status) {
            alert("Cuenta insertada correctamente.");
            $scope.getCuenta($scope.Cuenta.idCuenta); // Pending
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.updateCuenta = function() {
        $http({
            method: "PUT",
            data: $scope.Cuenta,
            url: contextPath + "/api/cuentas/"
        }).success(function(data, status) {
            alert("Cuenta " + $scope.Cuenta.idCuenta + " actualizada correctamente.");
            $scope.getEntidadBancaria($scope.entidadBancaria.idEntidadBancaria); // Pending
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.deleteCuenta = function() {
        $http({
            method: "DELETE",
            url: contextPath + "/api/cuentas/" + $scope.Cuenta.idCuenta
        }).success(function() {
            alert("Entidad " + $scope.Cuenta.idCuenta + " borrada correctamente.");
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };
}


