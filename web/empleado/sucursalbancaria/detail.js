function getSucursal($scope, $http, $routeParams) {
    $scope.getSucursalBancaria = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/sucursalbancaria/" + $scope.sucursalbancaria.id
        }).success(function(data) {
            $scope.sucursalbancaria = data;
            data.fecha = new Date(data.fecha);
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    if ($routeParams !== undefined) {
        $scope.sucursalbancaria = {};
        $scope.sucursalbancaria.id = $routeParams.id;
        $scope.getSucursalBancaria();
    }
}

function getEntidades($scope, $http, $routeParams) {
    if ($routeParams !== undefined && $routeParams.id !== undefined) {
        $scope.sucursalbancaria.idEntidad = $routeParams.id * 1;
        $scope.entidadDisabled = true;
    }
    $http({
        method: "GET",
        url: contextPath + "/api/entidadBancaria/"
    }).success(function(data, status) {
        $scope.entidadesBancarias = data;
    }).error(function(data, status) {
        alert("Fatal error: " + status);
    });
}

function start($scope) {
    $scope.sucursalbancaria = {};
    $scope.entidadDisabled = false;
}

/* Controllers */

app.controller("SucursalBancariaInsertController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.buttonText = 'Insertar';

        $scope.formSend = function() {
            $http({
                method: "POST",
                data: $scope.sucursalbancaria,
                url: contextPath + "/api/sucursalbancaria/"
            }).success(function(data) {
                goToListSucursal();
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        };

        start($scope);
        getEntidades($scope, $http, $routeParams);
    }
]);

app.controller("SucursalBancariaUpdateController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.buttonText = 'Actualizar';

        $scope.formSend = function() {
            $http({
                method: "PUT",
                data: $scope.sucursalbancaria,
                url: contextPath + "/api/sucursalbancaria/"
            }).success(function(data) {
                alert("Sucursal Bancaria " + $scope.sucursalbancaria.id + " correctamente actualizada.");
                $scope.getSucursalBancaria($scope.sucursalbancaria.id);
                goToListSucursal();
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        };

        start($scope);
        getSucursal($scope, $http, $routeParams);
        getEntidades($scope, $http);
    }
]);

function goToListSucursal() {
    location.replace('#/sucursalbancaria/');
}