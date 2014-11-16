
app.provider("UpdateUsuario", UpdateUsuarioProvider);

app.config(['baseUrl', 'UpdateUsuarioProvider', function (baseUrl, UpdateUsuarioProvider) {
        UpdateUsuarioProvider.setBaseUrl(baseUrl);
    }]);

app.controller("UpdateUserController", ['$scope', '$routeParams', 'UpdateUsuario', UpdateUserController]);


function UpdateUsuarioProvider() {
    var _baseUrl = "";
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', function ($http) {
            return new UpdateUsuario($http, _baseUrl);
        }];
}

function UpdateUsuario($http, baseUrl) {
    this.get = function (id, fnOk, fnError) {
        NProgress.start();
        $http({
            method: 'GET',
            url: baseUrl + '/api/usuario/' + id
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
            url: baseUrl + '/api/usuario/',
            data: user
        }).success(function (data, status, headers, config) {
            fnOk(data);
            NProgress.done();
        }).error(function (data, status, headers, config) {
            fnError(data, status);
            NProgress.done();
        });
    };

    this.insert = function (user, fnOk, fnError) {
        $http({
            method: 'POST',
            url: baseUrl + '/api/usuario/',
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
            url: baseUrl + '/api/usuario/password',
            data: user
        }).success(function (data, status, headers, config) {
            fnOk(data);
            NProgress.done();
        }).error(function (data, status, headers, config) {
            fnError(data, status);
            NProgress.done();
        });
    };



}

function UpdateUserController($scope, $routeParams, UpdateUsuario) {
    $scope.detailShown = true;
    $scope.passShown = false;
    $scope.mainButton = "Actualizar";

    UpdateUsuario.get($routeParams.id,
            function (data, status) {
                $scope.user = data;
            },
            function (data, status) {
                alert(status + ": " + data);
            }
    );

    $scope.update = function () {
        UpdateUsuario.update($scope.user
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
            UpdateUsuario.changePass($scope.user, function (data, status) {
                location.replace("#/usuario/");
            }, function (data, status) {
                alert(status + ": " + data);
            });
        }
    };
}


function UsuarioInsertController($scope, UpdateUsuario) {
    $scope.detailShown = false;
    $scope.passShown = true;
    $scope.mainButton = "Crear";

    $scope.update = function () {
        if ($scope.pass !== $scope.passrepeat) {
            alert("Las contraseñas no coinciden");
        } else {
            $scope.user.pass = $scope.pass;
            UpdateUsuario.insert($scope.user
                    , function (data, status) {
                        location.replace("#/usuario/");
                    }, function (data, status) {
                alert(status + ": " + data);
            });
        }
    };
}