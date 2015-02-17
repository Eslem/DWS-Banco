
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

        $http({
            method: 'GET',
            url: baseUrl + '/api/usuario/' + id
        }).success(function (data, status, headers, config) {
            fnOk(data);
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });


    };

    this.update = function (user, fnOk, fnError) {
        $http({
            method: 'PUT',
            url: baseUrl + '/api/usuario/',
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
            url: baseUrl + '/api/usuario/',
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
            url: baseUrl + '/api/usuario/password',
            data: user
        }).success(function (data, status, headers, config) {
            fnOk(data);
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });
    };



}

function UpdateUserController($scope, $routeParams, UpdateUsuario) {
    $scope.detailShown = true;
    $scope.passShown = false;
    $scope.mainButton = "Actualizar";
    $scope.mostrarErrores = false;


    UpdateUsuario.get($routeParams.id,
            function (data, status) {
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
        if (!$scope.formClient.$invalid) {
            if ($scope.password !== $scope.passrepeat) {
                alert("Las contraseñas no coinciden");
            } else {
               // $scope.user.password = $scope.password;
                UpdateUsuario.update($scope.user
                        , function (data, status) {
                            location.replace("#/usuario/");
                        }, function (data, status) {
                    if (status === 400)
                        $scope.errors = data.businessMessages;
                });
            }
        }
    };

    $scope.changePass = function () {
        $scope.mostrarErrores = true;
         if (!$scope.formClient.$invalid) {
        if ($scope.password !== $scope.passrepeat) {
            alert("Las contraseñas no coinciden");
        } else {
                $scope.user.password = $scope.password;
                UpdateUsuario.changePass($scope.user, function (data, status) {
                    location.replace("#/usuario/");
                    $scope.mostrarErrores = false;
                }, function (data, status) {
                    if (status === 400)
                        $scope.errors = data.businessMessages;
                });
            }
        };
    };
}


function UsuarioInsertController($scope, UpdateUsuario) {
    $scope.user = {};
    $scope.detailShown = false;
    $scope.passShown = true;
    $scope.mainButton = "Insertar";
    $scope.mostrarErrores = false;



    $scope.update = function () {
        $scope.mostrarErrores = true;
        if ($scope.pass !== $scope.passrepeat) {
            alert("Las contraseñas no coinciden");
        } else {
            if (!$scope.formClient.$invalid) {
                $scope.user.pass = $scope.pass;
                UpdateUsuario.insert($scope.user
                        , function (data, status) {
                            location.replace("#/usuario/");
                            $scope.mostrarErrores = false;
                        }, function (data, status) {
                    if (status === 400)
                        $scope.errors = data.businessMessages;
                });
            }

        }
    };
}