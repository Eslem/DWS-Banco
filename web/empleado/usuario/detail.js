/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


app.provider("UpdateAdministrador", UpdateAdministradorProvider);

app.config(['baseUrl', 'UpdateAdministradorProvider', function (baseUrl, UpdateAdministradorProvider) {
        UpdateAdministradorProvider.setBaseUrl(baseUrl);
    }]);

app.controller("UpdateAdministradorController", ['$scope', '$routeParams', 'UpdateAdministrador', UpdateAdministradorController]);


function UpdateAdministradorProvider() {
    var _baseUrl = "";
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', function ($http) {
            return new UpdateUser($http, _baseUrl);
        }];
}

function UpdateUser($http, baseUrl) {
    this.get = function (id, fnOk, fnError) {
        NProgress.start();
        $http({
            method: 'GET',
            url: baseUrl + '/api/administrador/' + id
        }).success(function (data, status, headers, config) {
            fnOk(data);
            NProgress.done();
        }).error(function (data, status, headers, config) {
            fnError(data, status);
            NProgress.done();
        });
    };

    this.update = function (user, fnOk, fnError) {
        $http({
            method: 'PUT',
            url: baseUrl + '/api/administrador/',
            data: user
        }).success(function (data, status, headers, config) {
            fnOk(data);
            NProgress.done();
        }).error(function (data, status, headers, config) {
            fnError(data, status);
            NProgress.done();
        });
    };
    this.changePass = function (user, fnOk, fnError) {
        $http({
            method: 'PUT',
            url: baseUrl + '/api/administrador/password',
            data: user
        }).success(function (data, status, headers, config) {
            fnOk(data);
            NProgress.done();
        }).error(function (data, status, headers, config) {
            fnError(data, status);
            NProgress.done();
        });
    }

}

function UpdateAdministradorController($scope, $routeParams, UpdateAdministrador) {
    UpdateAdministrador.get($routeParams.id,
            function (data, status) {
                $scope.user = data;
            },
            function (data, status) {
                alert(status + ": " + data);
            }
    );

    $scope.update = function () {
        // delete $scope.user.pass;
        UpdateAdministrador.update($scope.user
                , function (data, status) {
                    location.replace("#/usuario/");
                }, function (data, status) {
            alert(status + ": " + data);
        });
    };

    $scope.changePass = function () {
        if ($scope.pass !== $scope.passrepeat) {
            alert("Las contraseñas no coinciden");
        } else {
            $scope.user.pass = $scope.pass;
            UpdateUser.changePass($scope.user, function (data, status) {
                location.replace("#/administrador/");
            }, function (data, status) {
                alert(status + ": " + data);
            });
        }
    };
}
