

function selectedMovimiento($scope, $http, $routeParams) {
    $scope.getMovimiento = function () {
        $http({
            method: "GET",
            url: contextPath + "/api/movimiento/" + $scope.movimiento.id
        }).success(function (data) {
            $scope.movimiento = data;
        }).error(function (data, status) {
            alert("Fatal error: " + status);
        });
    };

    if ($routeParams !== undefined) {
        $scope.movimiento = {};
        $scope.movimiento.id = $routeParams.id;
        $scope.getMovimiento();
    }
}


/* Controllers */

app.controller("MovimientoInsertController", ["$scope", "$http", function ($scope, $http) {
        $scope.buttonText = 'Insertar';

        $scope.formSend = function () {
            $http({
                method: "POST",
                data: $scope.movimiento,
                url: contextPath + "/api/movimiento/"
            }).success(function (data) {
                alert("Movimiento correctamente insertado");
                $scope.getMovimiento($scope.movimiento.id);
                location.replace('#/movimiento/');
            }).error(function (data, status) {
                alert("Fatal error: " + status);
            });
        };


    }
]);

app.controller("MovimientoUpdateController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {
        $scope.buttonText = 'Actualizar';

        $scope.formSend = function () {
            $http({
                method: "PUT",
                data: $scope.movimiento,
                url: contextPath + "/api/movimiento/"
            }).success(function (data) {
                alert("Movimiento " + $scope.movimiento.id + " correctamente actualizado.");
                $scope.getMovimiento($scope.movimiento.id);
                location.replace('#/movimiento/');
            }).error(function (data, status) {
                alert("Fatal error: " + status);
            });
        };

        selectedMovimiento($scope, $http, $routeParams);
    }
]);










