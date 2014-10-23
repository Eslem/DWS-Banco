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
    app.service("updateUsuarioService", getListUsuariosProvider);

    app.factory('usuarioService', function ($rootScope) {
        var service = {};
        service.usuario = {};

        service.updateUsuario = function (usuario) {
            this.usuario = usuario;
            $rootScope.$broadcast("valuesUpdated");
        };
        return service;
    });
    
    app.factory('updateUsuario', function ($http) {
        var service = {};
        service.usuario = {};

        service.updateUsuario = function (usuario) {
            this.usuario = usuario;
            $rootScope.$broadcast("valuesUpdated");
        };
        return service;
    });

    app.config(['baseUrl', 'getListUsuariosProvider', 'updateUsuarioProvider', function (baseUrl, getListUsuariosProvider) {
            getListUsuariosProvider.setBaseUrl(baseUrl);
            updateUsuarioProvider.setBaseUrl(baseUrl);
        }]);

    app.controller("usuariosListController", ['$scope', 'getListUsuarios', 'usuarioService', usuariosListController]);
    app.controller("usuarioEditarController", ['$scope', 'updateUsuarioService', 'usuarioService', usuarioEditarController]);

}


function usuariosService() {
    var usuario;

    var setUsuario = function (newObj) {
        usuario = newObj;
    };

    var getUsuario = function () {
        return usuario;
    };

    return {
        setUsuario: setUsuario,
        getUsuario: getUsuario
    };
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
}

function updateUsuarioService($http, baseUrl) {
    this.put = function (usuario, fnOk, fnError) {
        $http({
            method: 'PUT',
            url: baseUrl + '/api/usuario/' + usuario.id
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
}

function usuarioEditarController($scope, updateUsuario, usuarioService) {
    $scope.$on('valuesUpdated', function () {
        $scope.usuario = usuarioService.usuario;
    });

    $scope.update = function (data) {
        updateUsuario.put($scope.usuario, function (data) {
            console.log(data);
        }, function (data) {
            alert(data);
        });
    };
}