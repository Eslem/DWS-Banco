/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


app.provider("UpdateAdministrador", UpdateAdministradorProvider);

app.config(['baseUrl', 'UpdateAdministradorProvider', function (baseUrl, UpdateAdministradorProvider) {
        UpdateAdministradorProvider.setBaseUrl(baseUrl);
    }]);

app.controller("UpdateAdministradoresController", ['$scope', '$routeParams', 'UpdateAdministrador', UpdateAdministradoresController]);


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
    }

}

function UpdateAdministradoresController($scope, $routeParams, UpdateAdministrador) {
    $scope.detailShown = true;
    $scope.passwordShown = false;
    $scope.mainButton = "Actualizar";
    UpdateAdministrador.get($routeParams.id,
            function (data, status) {
                $scope.user = data;
            },
            function (data, status) {
                alert(status + ": " + data);
            }
    );

    $scope.update = function () {
        // delete $scope.user.password;
        UpdateAdministrador.update($scope.user
                , function (data, status) {
                    location.replace("#/administrador/");
                }, function (data, status) {
            alert(status + ": " + data);
        });
    };

    $scope.changePass = function () {
        if ($scope.password !== $scope.passrepeat) {
            alert("Las contraseñas no coinciden");
        } else {
            $scope.user.password = $scope.password;
            UpdateAdministrador.changePass($scope.user, function (data, status) {
                location.replace("#/administrador/");
            }, function (data, status) {
                alert(status + ": " + data);
            });
        }
    };
}

function AdministradorInsertController($scope, UpdateAdministrador) {
    $scope.detailShown = false;
    $scope.passShown = true;
    $scope.mainButton = "Insertar";
    
    
    $scope.update = function () {
        if ($scope.password !== $scope.passrepeat) {
            alert("Las contraseñas no coinciden");
        } else {
            console.log($scope.password);
            $scope.user.password = $scope.password;
            UpdateAdministrador.insert($scope.user
                    , function (data, status) {
                        location.replace("#/administrador/");
                    }, function (data, status) {
                alert(status + ": " + data);
            });
        }
    };
}