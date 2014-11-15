function initializeMovimiento($scope, $http, $routeParams) {
    $scope.getMovimiento = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/movimiento/" + $scope.movimiento.id
        }).success(function(data) {
            $scope.movimiento = data;
        }).error(function(data, status) {
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

app.controller("MovimientoInsertController", ["$scope", "$http", function($scope, $http) {
        $scope.buttonText = 'Insertar';

        $scope.insertarMovimiento = function() {
            $http({
                method: "POST",
                data: $scope.movimiento,
                url: contextPath + "/api/movimiento/"
            }).success(function(data) {
                alert("Movimiento correctamente insertado");
                $scope.getMovimiento($scope.movimiento.id);
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        };

       
    }
]);

app.controller("MovimientoUpdateController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.buttonText = 'Actualizar';

        $scope.formSend = function() {
            $http({
                method: "PUT",
                data: $scope.movimiento,
                url: contextPath + "/api/movimiento/"
            }).success(function(data) {
                alert("Movimiento " + $scope.movimiento.id + " correctamente actualizado.");
                $scope.getMovimiento($scope.movimiento.id);
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        };

        initializeMovimiento($scope, $http, $routeParams);
    }
]);

app.controller("MovimientoDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.buttonText = 'Eliminar';

        $scope.formSend = function() {
            $http({
                method: "DELETE",
                url: contextPath + "/api/movimiento/" + $scope.movimiento.id
            }).success(function() {
                alert("Entidad " + $scope.movimiento.id + " correctamente borrada.");
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        };

        initializeMovimiento($scope, $http, $routeParams);
    }
]);










/*var app = angular.module("app", []);

app.controller("movimientoDetailController", function ($scope, $http) {
    
    $scope.getMovimiento = function () {
        $http({
            method: "GET",
            url: contextPath + "/api/movimiento/" + $scope.movimiento.id
        }).success(function (data, status) {
            $scope.movimiento = data;
        }).error(function (data, status) {
            alert("Error" + status);
        });


    };

    $scope.insertMovimiento = function () {
        $http({
            method: "POST",
            data: $scope.movimiento,
            url: contextPath + "/api/movimiento/"
        }).success(function (data, status) {
            alert("Movimiento añadido correctamente");
            $scope.getMovimiento($scope.movimiento.id);
        }).error(function (data, status) {
            alert("Error " + status);
        });
    };


    $scope.updateMovimiento = function () {
        $http({
            method: "PUT",
            data: $scope.movimiento,
            url: contextPath + "/api/movimiento/"
        }).success(function (data, status) {
            alert("Movimiento " + $scope.movimiento.id + " actualizado correctamente");
            $scope.getMovimiento($scope.movimiento.id);
        }).error(function (data, status) {
            alert("Error: " + status);
        });
    };


    $scope.deleteMovimiento = function () {
        $http({
            method: "DELETE",
            url: contextPath + "/api/movimiento/" + $scope.movimiento.id
        }).success(function (data, status) {
            alert("Cuenta eleminada correctamente");
            $scope.getMovimiento($scope.movimiento.id);
        }).error(function (data, status) {
            alert("Error " + status);
        });
    };

    $scope.movimiento={};
    $scope.movimiento.id=getURLParameter('id');
    $scope.getMovimiento();
    


});*/