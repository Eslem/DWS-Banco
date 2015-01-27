var app = angular.module("app", ['ngRoute', 'ngAnimate', 'ui.date']).run(function ($rootScope) {
});

app.config(function ($provide, $httpProvider) {
    $provide.factory('HTTPLoadingInterceptor', function ($q) {
        return {
            'request': function (config) {
                NProgress.start();
                return config;
            },
            'requestError': function (rejection) {
                return $q.reject(rejection);
            },
            'response': function (response) {
                NProgress.done();
                return response;
            },
            // optional method
            'responseError': function (rejection) {
                NProgress.done();
                return $q.reject(rejection);
            }
        };
    });

    $httpProvider.interceptors.push("HTTPLoadingInterceptor");
});

app.constant("baseUrl", contextPath);

app.controller("EmpleadoController", function ($scope, $rootScope, $location, $http, UpdateAdministrador) {
    $scope.isActive = function (route) {
        return (route === $location.path());
    };

    $http({
        method: "GET",
        url: contextPath + "/api/session/"
    }).success(function (data, status) {
        if (status === 200) {
            $rootScope.login = true;
            $rootScope.userLogued = data;
            $scope.$on('$routeChangeStart', function (next, current) {
                if (($rootScope.login === undefined || $rootScope.login === false) && $location.path() !== "/login") {
                    alert("Aceso denegado, debes iniciar sesion");
                    location.replace('#/login');
                }
            });

            $scope.user = data.nombre;
        } else {
            location.replace('#/login');
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
            location.replace('#/login');
        }).error(function (data, status) {
            alert("Fatal error " + status + ": " + data);
        });
    };

    $scope.update = function () {
        UpdateAdministrador.update($scope.userLogued, function (data, status) {
            alert("Perfil actualizado");
            location.replace("#/profile/");
        }, function (data, status) {
            console.log(status + ": " + data);
        });
    };

});

app.constant('uiDateConfig', {
    dateFormat: "dd/mm/yy",
    fistDay: 1
});