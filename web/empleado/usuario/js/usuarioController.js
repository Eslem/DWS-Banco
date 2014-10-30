/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angularConfig();

function angularConfig() {
    var app = angular.module("app", []);
    app.constant("baseUrl", contextPath);
    app.provider("getListUsuarios", getListUsuariosProvider);
    app.provider("updateUsuario", updateUsuarioProvider);

    app.factory('usuarioService', function ($rootScope) {
        var service = {};
        service.usuario = {};

        service.updateUsuario = function (usuario) {
            this.usuario = usuario;
            $rootScope.$broadcast("valuesUpdated");
        };
        return service;
    });

    app.config(['baseUrl', 'getListUsuariosProvider', 'updateUsuarioProvider', function (baseUrl, getListUsuariosProvider, updateUsuarioProvider) {
            getListUsuariosProvider.setBaseUrl(baseUrl);
            updateUsuarioProvider.setBaseUrl(baseUrl);
        }]);

    app.controller("usuariosListController", ['$scope', 'getListUsuarios', 'usuarioService', usuariosListController]);
    app.controller("usuarioEditarController", ['$scope', 'usuarioService', 'updateUsuario', usuarioEditarController]);

}

function getListUsuariosProvider() {
    var _baseUrl;
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', function ($http) {
            return new getListUsuarios($http, _baseUrl);
        }];
}

function updateUsuarioProvider() {
    var _baseUrl;
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', function ($http) {
            return new updateUsuario($http, _baseUrl);
        }];
}

function getListUsuarios($http, baseUrl) {
    this.get = function (fnOk, fnError) {
        $http({
            method: 'GET',
            url: baseUrl + '/api/usuario'
        }).success(function (data, status, headers, config) {
            fnOk(data);
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });
    };


    this.delete = function (user, fnOk, fnError) {
        $http({
            method: 'DELETE',
            url: baseUrl + '/api/usuario/' + user.id
        }).success(function (data, status, headers, config) {
            fnOk(data);
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });
    };
}

function updateUsuario($http, baseUrl) {
    this.update = function (usuario, fnOk, fnError) {
        $http({
            method: 'PUT',
            url: baseUrl + '/api/usuario'
        }).success(function (data, status, headers, config) {
            fnOk(data);
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });
    };
}


function usuariosListController($scope, getListUsuarios, usuarioService) {
    getListUsuarios.get(function (data) {
        $scope.usuarios = data;
    }, function (data) {
        alert(data);
    });

    $scope.editar = function (usuario) {
        usuarioService.updateUsuario(usuario);
    };

    $scope.removeUser = function (usuario) {
        $scope.usuarioEliminar = usuario;
    };

    $scope.aceptEliminar = function () {
        getListUsuarios.delete($scope.usuarioEliminar, function (data) {
            removeRow($scope);
        }, function (data) {
            alert(data);
        });
    };

}


function removeRow($scope) {
    var index = -1;
    var usuariosArray = eval($scope.usuarios);
    for (var i = 0; i < usuariosArray.length; i++) {
        if (usuariosArray[i].id === $scope.usuarioEliminar.id) {
            index = i;
            break;
        }
    }
    if (index === -1) {
        alert("Something gone wrong");
    }
    $scope.usuarios.splice(index, 1);
    $('#modalEliminar').modal('hide')
}

function usuarioEditarController($scope, usuarioService, updateUsuario) {
    $scope.$on('valuesUpdated', function () {
        $scope.usuario = usuarioService.usuario;
    });

    $scope.update = function () {
        updateUsuario.update($scope.usuario, function (data) {
            console.log(data);
        }, function (data) {
            console.log(data);
        });
    };
}