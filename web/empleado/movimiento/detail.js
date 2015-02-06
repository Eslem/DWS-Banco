function selectedMovimiento($scope, $http, $routeParams) {
    $scope.getMovimiento = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/movimiento/" + $scope.movimiento.id
        }).success(function(data) {
            $scope.movimiento = data;
            data.fecha = new Date(data.fecha);
        }).error(function(data, status) {
            if (status === 400) $scope.errors = data.businessMessages;
        });
    };

    if ($routeParams !== undefined) {
        $scope.movimiento = {};
        $scope.movimiento.id = $routeParams.id;
        $scope.getMovimiento();
    }
}

function getCuenta($scope, $http) {

    $http({
        method: "GET",
        url: contextPath + "/api/cuenta/"
    }).success(function(data, status) {
        $scope.cuentas = data;
    }).error(function(data, status) {
        if (status === 400) $scope.errors = data.businessMessages;
    });
}

/* Controllers */

app.controller("MovimientoInsertController", ["$scope", "$http", function($scope, $http) {
        $scope.movimiento = {};
        $scope.buttonText = 'Insertar';

        $scope.formSend = function() {
            $http({
                method: "POST",
                data: $scope.movimiento,
                url: contextPath + "/api/movimiento/"
            }).success(function(data) {
                //alert("Movimiento correctamente insertado");
                goToListMovimiento();
            }).error(function(data, status) {
                if (status === 400) $scope.errors = data.businessMessages;
            });
        };

        getCuenta($scope, $http);

    }
]);

function goToListMovimiento() {
    location.replace('#/movimiento/');
}

