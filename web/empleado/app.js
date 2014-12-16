var app = angular.module("app", ['ngRoute', 'ngAnimate']).run(function ($rootScope) {
    $rootScope.login = false;
});
app.constant("baseUrl", contextPath);

app.controller("EmpleadoController", function ($scope, $rootScope, $location, $http) {
    $scope.isActive = function (route) {
        return (route === $location.path());
    };

    $http({
        method: "GET",
        data: $scope.entidadBancaria,
        url: contextPath + "/api/session/"
    }).success(function (data, status) {
        if (status === 200) {
            $rootScope.login = true;
            $rootScope.userLogued = data;
        }
    }).error(function (data, status) {
        if (status !== 403) {
            alert("Fatal error " + status + ": " + data);
        }
    });

    $scope.logout = function () {
        $http({
            method: "DELETE",
            data: $scope.entidadBancaria,
            url: contextPath + "/api/session/"
        }).success(function (data, status) {
            $rootScope.login = false;
        }).error(function (data, status) {
            alert("Fatal error " + status + ": " + data);
        });
    };

});
