function initializeEntidadBancaria($scope, $http, $routeParams) {
    $scope.getEntidadBancaria = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/entidadBancaria/" + $scope.entidadBancaria.id
        }).success(function(data) {
            $scope.entidadBancaria = data;
            data.fecha = new Date(data.fecha);
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    if ($routeParams !== undefined) {
        $scope.entidadBancaria = {};
        $scope.entidadBancaria.id = $routeParams.id;
        $scope.getEntidadBancaria();
        $scope.idVisible = true;
    }
}

function initializeSucursalesBancarias($scope, $http) {
    $http({
        method: "GET",
        url: contextPath + "/api/entidadBancaria/" + $scope.entidadBancaria.id + "/sucursalesBancarias/"
    }).success(function(data, status) {
        console.log(data);
        $scope.sucursales = data;
    }).error(function(data, status) {
        alert("Fatal error: " + status);
    });

    $scope.crearSucursal = function() {
        location.replace("#/sucursalbancaria/insert/");
    };

    $scope.editarSucursal = function(id) {
        location.replace('#/sucursalbancaria/update/' + id);
    };
}

function goToEntidadBancariaList() {
    location.replace('#/entidadbancaria/');
}


/* Controllers */

app.controller("EntidadBancariaInsertController", ["$scope", "$http", function($scope, $http) {
        $scope.buttonText = 'Insertar';
        $scope.show = 'False';

        $scope.formSend = function() {
            $http({
                method: "POST",
                data: $scope.entidadBancaria,
                url: contextPath + "/api/entidadBancaria/"
            }).success(function(data) {
                goToEntidadBancariaList();
                goToListEntidad();
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        };
    }
]);

app.controller("EntidadBancariaUpdateController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.buttonText = 'Actualizar';
        $scope.show = 'True';

        $scope.formSend = function() {
            $http({
                method: "PUT",
                data: $scope.entidadBancaria,
                url: contextPath + "/api/entidadBancaria/"
            }).success(function(data) {
                goToEntidadBancariaList();
                goToListEntidad();
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        };

        initializeEntidadBancaria($scope, $http, $routeParams);
        initializeSucursalesBancarias($scope, $http);
        $scope.createSucursal = function(idEntidad) {
            console.log(idEntidad);
            location.replace('#/entidadbancaria/' + idEntidad + '/sucursalbancaria/');
        };
    }
]);

function goToListEntidad() {
    location.replace('#/entidadbancaria/');
}