/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


app.provider("ListUsuarios", ListUsuariosProvider);

app.config(['baseUrl', 'ListUsuariosProvider', function (baseUrl, ListUsuariosProvider) {
        ListUsuariosProvider.setBaseUrl(baseUrl);
    }]);

app.controller("ListUsuariosController", ['$scope', 'ListUsuarios', ListUsuariosController]);


function ListUsuariosProvider() {
    var _baseUrl = "";
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', function ($http) {
            return new ListUsuarios($http, _baseUrl)
        }];
}

function ListUsuarios($http, baseUrl) {
    this.get = function (fnOk, fnError) {
        NProgress.start();
        $http({
            method: 'GET',
            url: baseUrl + '/api/usuario'
        }).success(function (data, status, headers, config) {
            fnOk(data);
            NProgress.done();
        }).error(function (data, status, headers, config) {
            fnError(data, status);
            NProgress.done();
        });
    };

    this.delete = function (id, fnOk, fnError) {
        NProgress.start();
        $http({
            method: 'DELETE',
            url: baseUrl + '/api/usuario/' + id
        }).success(function (data, status, headers, config) {
            fnOk(data);
            NProgress.done();
        }).error(function (data, status, headers, config) {
            fnError(data, status);
            Progress.done();
        });
    }
}

function ListUsuariosController($scope, ListUsuarios) {
    ListUsuarios.get(
            function (data, status) {
                $scope.usuarios = data;
            },
            function (data, status) {
                alert(status + ": " + data);
            }
    );

    $scope.borrar = function (usuario) {
        $scope.usuarioBorrar = usuario;
    };

    $scope.confirmBorrar = function () {
        ListUsuarios.delete($scope.usuarioBorrar.id,
                function (data, status) {
                    var id = getUserScoperId($scope, $scope.usuarioBorrar.id);
                    $scope.usuarios.splice(id, 1);
                },
                function (data, status) {
                    alert(status + ": " + data);
                });
    };
    $scope.editar = function (userId) {
        location.replace('#/usuario/update/' + userId.id);
    };
    $scope.crear = function () {
        location.replace('#/usuario/insert/');
    };
}


function getUserScoperId($scope, userId) {
    index = -1;
    var array = eval($scope.usuarios);
    for (var i = 0; i < array.length; i++) {
        if (array[i].id === userId) {
            index = i;
            break;
        }
    }
    return index;
}