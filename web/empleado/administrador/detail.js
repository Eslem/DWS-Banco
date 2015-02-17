app.provider("UpdateAdministrador", UpdateAdministradorProvider);

app.config(['baseUrl', 'UpdateAdministradorProvider', function (baseUrl, UpdateAdministradorProvider) {
        UpdateAdministradorProvider.setBaseUrl(baseUrl);
    }]);

app.controller("UpdateAdministradoresController", ['$scope', '$routeParams', 'UpdateAdministrador', '$rootScope', UpdateAdministradoresController]);


function UpdateAdministradorProvider() {
    var _baseUrl = "";
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', function ($http) {
            return new UpdateAdministrador($http, _baseUrl);
        }];
}

function UpdateAdministrador($http, baseUrl) {
    this.get = function (id, fnOk, fnError) {
        $http({
            method: 'GET',
            url: baseUrl + '/api/administrador/' + id
        }).success(function (data, status, headers, config) {
            fnOk(data);
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });
    };

    this.update = function (user, fnOk, fnError) {
        $http({
            method: 'PUT',
            url: baseUrl + '/api/administrador/',
            data: user
        }).success(function (data, status, headers, config) {
            fnOk(data);
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });
    };

    this.insert = function (user, fnOk, fnError) {
        $http({
            method: 'POST',
            url: baseUrl + '/api/administrador/',
            data: user
        }).success(function (data, status, headers, config) {
            fnOk(data);
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });
    };
    this.changePass = function (user, fnOk, fnError) {
        $http({
            method: 'PUT',
            url: baseUrl + '/api/administrador/password',
            data: user
        }).success(function (data, status, headers, config) {
            fnOk(data);
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });
    };

}

function UpdateAdministradoresController($scope, $routeParams, UpdateAdministrador, $rootScope) {
    $scope.detailShown = true;
    $scope.passwordShown = false;
    $scope.mainButton = "Actualizar";
    $scope.mostrarErrores = false;
    if (!$rootScope.login) {
        location.replace('#/login/');
    }

    UpdateAdministrador.get($routeParams.id,
            function (data, status) {
                  alert(JSON.stringify($scope.user));
                $scope.user = data;
            },
            function (data, status) {
                if (status === 400)
                    $scope.errors = data.businessMessages;
            }
    );

    $scope.update = function () {
           $scope.mostrarErrores = true;
        // delete $scope.user.password;
        if (!$scope.formAdmin.$invalid) {
            alert(JSON.stringify($scope.user));
            UpdateAdministrador.update($scope.user
                    , function (data, status) {
                        location.replace("#/administrador/");
                    }, function (data, status) {
                if (status === 400)
                    $scope.errors = data.businessMessages;
            });
        }
        $scope.mostrarErrores = false;
    };

    $scope.changePass = function () {
        if (!scope.formAdmin.$invalid) {
            if ($scope.password !== $scope.passrepeat) {
                alert("Las contraseñas no coinciden");
            } else {
                $scope.user.password = $scope.password;
                UpdateAdministrador.changePass($scope.user, function (data, status) {
                    location.replace("#/administrador/");
                }, function (data, status) {
                    if (status === 400)
                        $scope.errors = data.businessMessages;
                });
            }
        }
        $scope.mostrarErrores = false;
    };
}

function AdministradorInsertController($scope, $rootScope, UpdateAdministrador) {
    $scope.user = {};
    $scope.detailShown = false;
    $scope.passShown = true;
    $scope.mainButton = "Insertar";
    $scope.mostrarErrores = false;

    if (!$rootScope.login) {
        location.replace('#/login/');
    }

    $scope.update = function () {
        $scope.mostrarErrores = true;
        if (!scope.formAdmin.$invalid) {
            if ($scope.password !== $scope.passrepeat) {
                alert("Las contraseñas no coinciden");
            } else {
                console.log($scope.password);
                //$scope.user.password = $scope.password;
                UpdateAdministrador.insert($scope.user
                        , function (data, status) {
                            location.replace("#/administrador/");

                        }, function (data, status) {
                    if (status === 400)
                        $scope.errors = data.businessMessages;
                });
            }
        }
    };
}