function initializeCuenta($scope, $http, $routeParams) {
    $scope.getCuenta = function () {
        $http({
            method: "GET",
            url: contextPath + "/api/cuenta/" + $scope.cuenta.id
        }).success(function (data) {
            $scope.cuenta = data;
        }).error(function (data, status) {
            alert("Fatal error: " + status);
        });
    };

    if ($routeParams !== undefined) {
        $scope.cuenta = {};
        $scope.cuenta.id = $routeParams.idCuenta;
        $scope.getCuenta();
    }
}

/* Controllers */

app.controller("CuentaInsertController", ["$scope", "$http", function ($scope, $http) {
        $scope.buttonText = 'Insertar';

        $scope.formSend = function () {
            $http({
                method: "POST",
                data: $scope.cuenta,
                url: contextPath + "/api/cuenta/"
            }).success(function (data) {
                alert("Cuenta correctamente insertada");
                $scope.getCuenta($scope.cuenta.id);
            }).error(function (data, status) {
                alert("Fatal error: " + status);
            });
        };
    }
]);

app.controller("CuentaEditController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {
        $scope.buttonText = 'Actualizar';

        $scope.formSend = function () {
            $http({
                method: "PUT",
                data: $scope.cuenta,
                url: contextPath + "/api/cuenta/"
            }).success(function (data) {
                alert("Cuenta " + $scope.cuenta.id + " correctamente actualizado.");
                $scope.getCuenta($scope.cuenta.id);
            }).error(function (data, status) {
                alert("Fatal error: " + status);
                console.log($scope.cuenta);
            });
        };

        initializeCuenta($scope, $http, $routeParams);
    }
]);

app.controller("CuentaDeleteController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {
        $scope.buttonText = 'Eliminar';

        $scope.formSend = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/cuenta/" + $scope.cuenta.id
            }).success(function () {
                alert("Cuenta " + $scope.cuenta.id + " correctamente borrada.");
            }).error(function (data, status) {
                alert("Fatal error: " + status);
            });
        };

        initializeCuenta($scope, $http, $routeParams);
    }
]);