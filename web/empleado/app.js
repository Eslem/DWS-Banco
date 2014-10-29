var app = angular.module("app", ['ngRoute']);

app.controller("EmpleadoController", function($scope) {
    $scope.locations = [
        {
            value: 'EntidadBancaria/',
            text: 'Entidad Bancaria'
        }, {
            value: 'Usuario/',
            text: 'Usuario'
        }, {
            value: 'Cuenta/',
            text: 'Cuenta'
        }, {
            value: 'Movimiento/',
            text: 'Movimiento'
        }
    ];
});