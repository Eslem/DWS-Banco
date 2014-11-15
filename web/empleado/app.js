var app = angular.module("app", ['ngRoute']);

app.controller("EmpleadoController", function($scope, $location) {
    $scope.locations = [
        {
            value: 'entidadbancaria/',
            text: 'Entidad Bancaria'
        }, {
            value: 'usuario/',
            text: 'Usuario'
        }, {
            value: 'cuenta/',
            text: 'Cuenta'
        }, {
            value: 'movimiento/',
            text: 'Movimiento'
        }
    ];

    $scope.isActive = function(location) {
        return location === ($location.path().substring(1) || '/');
    };
});