

function selectedSucursal($scope, $http, $routeParams) {
    $scope.getSucursalBancaria = function () {
        $http({
            method: "GET",
            url: contextPath + "/api/sucursalbancaria/" + $scope.sucursalbancaria.id
        }).success(function (data) {
            $scope.sucursalbancaria = data;
            data.fecha = new Date(data.fecha);
        }).error(function (data, status) {
            alert("Fatal error: " + status);
        });
    };

    if ($routeParams !== undefined) {
        $scope.sucursalbancaria = {};
        $scope.sucursalbancaria.id = $routeParams.id;
        $scope.getSucursalBancaria();
    }
}

function getEntidades($scope, $http) {
    $http({
        method: "GET",
        url: contextPath + "/api/entidadBancaria/"
    }).success(function (data, status) {
        $scope.entidadesBancarias = data;
    }).error(function (data, status) {
        alert("Fatal error: " + status);
    });
}

/* Controllers */


app.controller("SucursalBancariaInsertController", ["$scope", "$http", function ($scope, $http) {
        $scope.buttonText = 'Insertar';

        $scope.formSend = function () {
            $http({
                method: "POST",
                data: $scope.sucursalbancaria,
                url: contextPath + "/api/sucursalbancaria/"
            }).success(function (data) {
                alert("Sucursal Bancaria  correctamente insertada");
                $scope.getSucursalBancaria($scope.sucursalbancaria.id);
                goToListSucursal();
            }).error(function (data, status) {
                alert("Fatal error: " + status);
            });
        };

        getEntidades($scope, $http);
    }
]);

app.controller("SucursalBancariaUpdateController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {
        $scope.buttonText = 'Actualizar';

        $scope.formSend = function () {
            $http({
                method: "PUT",
                data: $scope.sucursalbancaria,
                url: contextPath + "/api/sucursalbancaria/"
            }).success(function (data) {
                alert("Sucursal Bancaria " + $scope.sucursalbancaria.id + " correctamente actualizada.");
                $scope.getSucursalBancaria($scope.sucursalbancaria.id);
                goToListSucursal();
            }).error(function (data, status) {
                alert("Fatal error: " + status);
            });
        };

        selectedSucursal($scope, $http, $routeParams);
        getEntidades($scope, $http);

    }
]);

function goToListSucursal() {
    location.replace('#/sucursalbancaria/');
}
