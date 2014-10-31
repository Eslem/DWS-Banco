/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

var app = angular.module("app", []);
app.constant("baseUrl", contextPath);
app.provider("ListUsuarios", ListUsuariosProvider);

app.config(['baseUrl', 'ListUsuariosProvider', function (baseUrl, ListUsuariosProvider) {
        ListUsuariosProvider.setBaseUrl(baseUrl);
    }]);


app.controller("listUsuariosController", ['$scope', 'ListUsuarios', function ($scope, ListUsuarios) {
        ListUsuarios.get(
                function (data, status) {
                    $scope.usuarios = data;
                },
                function (data, status) {
                    alert(status + ": " + data);
                }
        );
    }
]);

