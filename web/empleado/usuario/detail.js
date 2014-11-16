/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


app.provider("UpdateUser", UpdateUserProvider);

app.config(['baseUrl', 'UpdateUserProvider', function (baseUrl, UpdateUserProvider) {
        UpdateUserProvider.setBaseUrl(baseUrl);
    }]);

app.controller("UpdateUserController", ['$scope', '$routeParams', 'UpdateUser', UpdateUserController]);


function UpdateUserProvider() {
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
    }

}

function UpdateUserController($scope, $routeParams, UpdateUser) {
    UpdateUser.get($routeParams.id,
            function (data, status) {
                $scope.user = data;
            },
            function (data, status) {
                alert(status + ": " + data);
            }
    );

    $scope.update = function () {
        // delete $scope.user.pass;
        UpdateUser.update($scope.user
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
                location.replace("#/usuario/");
            }, function (data, status) {
                alert(status + ": " + data);
            });
        }
    };
}
