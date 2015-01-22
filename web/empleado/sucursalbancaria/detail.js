function start($scope, $http, $routeParams) {
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

    $scope.getEntidades = function($scope, $http, $routeParams) {
        if ($routeParams !== undefined && $routeParams.idEntidad !== undefined) {
            $scope.sucursalbancaria.idEntidad = $routeParams.idEntidad * 1;
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
    };

    $scope.getCuentas = function($scope, $http) {
        $http({
            method: "GET",
            url: contextPath + "/api/sucursalbancaria/" + $scope.sucursalbancaria.id + "/cuentas/"
        }).success(function(data) {
            $scope.cuentas = data;
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.sucursalbancaria = {};
    if ($routeParams !== undefined && $routeParams.id !== undefined) {
        $scope.sucursalbancaria.id = $routeParams.id;
        $scope.getSucursalBancaria();
    }
    $scope.getEntidades($scope, $http, $routeParams);
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

        start($scope, $http, $routeParams);
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
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        };


        $scope.deleteCuenta = function(id) {
            if (confirm('¿Confirma usted el borrado de la cuenta "' + $scope.sucursalBancaria.nombre + '"?')) {
                $http({
                    method: "DELETE",
                    url: contextPath + "/api/cuenta/" + id
                }).success(function() {
                    getCuentas();
                }).error(function(data, status) {
                    alert("Fatal error: " + status);
                });
            } else {
                getCuentas();
            }
        };

        $scope.editCuenta = function(id) {
            location.replace("#/cuenta/edit/" + id);
        };

        $scope.crearCuenta = function(id) {
            location.replace("#/cuenta/insert");
        };

        start($scope, $http, $routeParams);
        $scope.getCuentas($scope, $http);
    }
]);