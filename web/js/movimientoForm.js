var app = angular.module("app", []);

function ControladorMovimiento($scope, $http) {
    $scope.getMovimiento = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/movimiento/" + $scope.movimiento.idMovimiento
        }).success(function(data, status) {
            $scope.movimiento = data;
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.insertMovimiento = function() {
        $http({
            method: "POST",
            data: $scope.movimiento,
            url: contextPath + "/api/movimiento/"
        }).success(function(data, status) {
            alert("Movimiento correctamente insertada.");
            $scope.getMovimiento($scope.entidadBancaria.idMovimientoBancaria); // Pending
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.updateMovimiento = function() {
        $http({
            method: "PUT",
            data: scopeToJSON(),
            url: contextPath + "/api/movimiento/"
        }).success(function(data, status) {
            alert("Movimiento " + $scope.movimiento.idMovimiento + " correctamente actualizada.");
            $scope.getMovimiento($scope.entidadBancaria.idMovimientoBancaria); // Pending
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.deleteMovimiento = function() {
        $http({
            method: "DELETE",
            url: contextPath + "/api/movimiento/" + $scope.movimiento.idMovimiento
        }).success(function() {
            alert("Movimiento " + $scope.movimiento.idMovimiento + " correctamente borrada.");
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };
}