function initializeCuenta($scope, $http, $routeParams) {
    $scope.getCuenta = function () {
        $http({
            method: "GET",
            url: contextPath + "/api/cuenta/" + $scope.cuenta.id
        }).success(function (data) {
            $scope.cuenta = data;
            data.fecha = new Date(data.fecha);
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

function getMovimientos($scope, $http) {
    $http({
        method: "GET",
        url: contextPath + "/api/cuenta/" + $scope.cuenta.id + "/movimiento"
    }).success(function(data, status) {
        console.log(data);
        $scope.movimientos = data;
    }).error(function(data, status) {
        alert("Fatal error: " + status);
    });
    
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
                goToListCuenta();
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
                alert("Cuenta correctamente actualizado.");
                goToListCuenta();
                $scope.getCuenta($scope.cuenta.id);
            }).error(function (data, status) {
                alert("Fatal error: " + status);
            });           
        };
        initializeCuenta($scope, $http, $routeParams);
        getMovimientos($scope, $http);
        
    }
]);

function goToListCuenta() {
    location.replace('#/cuenta/');
}

