var app = angular.module("app", ['ngRoute', 'ngAnimate']);
app.constant("baseUrl", contextPath);

app.controller("EmpleadoController", function($scope, $location) {
    $scope.isActive = function (route) {
        console.log($location.path());
        return (route === $location.path());
    };
});
