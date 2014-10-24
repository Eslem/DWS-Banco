var app = angular.module("app", ['ngRoute']);

function initialize($scope, $http, $routeParams) {
    $scope.getEntidadBancaria = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/entidadBancaria/" + $scope.entidadBancaria.id
        }).success(function(data) {
            $scope.entidadBancaria = data;
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };

    if ($routeParams !== undefined) {
        $scope.entidadBancaria = {};
        $scope.entidadBancaria.id = $routeParams.id;
        $scope.getEntidadBancaria();
    }
}

app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/insert', {
            templateUrl: "detailForm.html",
            controller: "EntidadBancariaInsertController"
        });

        $routeProvider.when('/update/:id', {
            templateUrl: "detailForm.html",
            controller: "EntidadBancariaUpdateController"
        });

        $routeProvider.when('/delete/:id', {
            templateUrl: "detailForm.html",
            controller: "EntidadBancariaDeleteController"
        });

        /*$routeProvider.otherwise({
         redirectTo: "menu.html"
         });*/
    }
]);


/* Controllers */

app.controller("EntidadBancariaInsertController", ["$scope", "$http", function($scope, $http) {
        $scope.buttonText = 'Insertar';

        $scope.formSend = function() {
            $http({
                method: "POST",
                data: $scope.entidadBancaria,
                url: contextPath + "/api/entidadBancaria/"
            }).success(function(data) {
                alert("Entidad correctamente insertada.");
                $scope.getEntidadBancaria($scope.entidadBancaria.id);
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        };

        initialize($scope, $http);
    }
]);

app.controller("EntidadBancariaUpdateController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.buttonText = 'Actualizar';

        $scope.formSend = function() {
            $http({
                method: "PUT",
                data: $scope.entidadBancaria,
                url: contextPath + "/api/entidadBancaria/"
            }).success(function(data) {
                alert("Entidad " + $scope.entidadBancaria.id + " correctamente actualizada.");
                $scope.getEntidadBancaria($scope.entidadBancaria.id);
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        };

        initialize($scope, $http, $routeParams);
    }
]);

app.controller("EntidadBancariaDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.buttonText = 'Eliminar';

        $scope.formSend = function() {
            $http({
                method: "DELETE",
                url: contextPath + "/api/entidadBancaria/" + $scope.entidadBancaria.id
            }).success(function() {
                alert("Entidad " + $scope.entidadBancaria.id + " correctamente borrada.");
            }).error(function(data, status) {
                alert("Fatal error: " + status);
            });
        };

        initialize($scope, $http, $routeParams);
    }
]);