function initializeEntidadBancaria($scope, $http, $routeParams) {
    $scope.getEntidadBancaria = function () {
        $http({
            method: "GET",
            url: contextPath + "/api/entidadBancaria/" + $scope.entidadBancaria.id
        }).success(function (data) {
            $scope.entidadBancaria = data;
            data.fecha = new Date(data.fecha);
        }).error(function (data, status) {
            if (status === 400)
                $scope.errors = data.businessMessages;
        });
    };

    if ($routeParams !== undefined) {
        $scope.entidadBancaria = {};
        $scope.entidadBancaria.id = $routeParams.id;
        $scope.getEntidadBancaria();
        $scope.idVisible = true;
    }
}

function getSucursalesBancarias($scope, $http) {
    $http({
        method: "GET",
        url: contextPath + "/api/entidadBancaria/" + $scope.entidadBancaria.id + "/sucursalesBancarias/"
    }).success(function (data, status) {
        $scope.sucursales = data;
    }).error(function (data, status) {
        if (status === 400)
            $scope.errors = data.businessMessages;
    });
}

function initializeSucursalesBancarias($scope, $http) {
    getSucursalesBancarias($scope, $http);

    $scope.crearSucursal = function () {
        location.replace("#/sucursalbancaria/insert/");
    };

    $scope.editarSucursal = function (id) {
        location.replace('#/sucursalbancaria/update/' + id);
    };
}


/* Controllers */

app.controller("EntidadBancariaInsertController", ["$scope", "$http", function ($scope, $http) {
        $scope.entidadBancaria = {};
        $scope.buttonText = 'Insertar';
        $scope.mostrar = false;
        $scope.mostarErrores = false;
     

        $scope.formSend = function () {
            $scope.mostrarErrores = true;
            if (!$scope.formEntidad.$invalid) {
                $http({
                    method: "POST",
                    data: $scope.entidadBancaria,
                    url: contextPath + "/api/entidadBancaria/"
                }).success(function (data) {
                    goToListEntidad();
                    $scope.mostrarErrores = false;
                }).error(function (data, status) {
                    if (status === 400)
                        $scope.errors = data.businessMessages;
                });
            }

        };
    }
]);

app.controller("EntidadBancariaUpdateController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {
        $scope.buttonText = 'Actualizar';
        $scope.mostrar = true;
        $scope.mostrarErrores = false;
        $scope.formSend = function () {
            $scope.mostrarErrores = true;
            if (!$scope.formEntidad.$invalid) {
                $http({
                    method: "PUT",
                    data: $scope.entidadBancaria,
                    url: contextPath + "/api/entidadBancaria/"
                }).success(function (data) {
                    goToListEntidad();
                }).error(function (data, status) {
                    if (status === 400)
                        $scope.errors = data.businessMessages;
                });
            }
        };

        initializeEntidadBancaria($scope, $http, $routeParams);
        initializeSucursalesBancarias($scope, $http);

        $scope.createSucursal = function (idEntidad) {
            location.replace('#/entidadbancaria/' + idEntidad + '/sucursalbancaria/');
        };

        $scope.deleteSucursal = function (sucursalBancaria) {
            if (confirm('¿Confirma usted el borrado de la Sucursal Bancaria "' + sucursalBancaria.nombre + '"?')) {
                $http({
                    method: "DELETE",
                    url: contextPath + "/api/sucursalbancaria/" + sucursalBancaria.id
                }).success(function () {
                    getSucursalesBancarias($scope, $http);
                }).error(function (data, status) {
                    if (status === 400)
                        $scope.errors = data.businessMessages;
                });
            } else {
                $scope.findAll();
            }
        };
    }
]);

function goToListEntidad() {
    location.replace('#/entidadbancaria/');
}