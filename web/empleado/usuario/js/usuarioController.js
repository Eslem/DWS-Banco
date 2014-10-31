/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angularConfig();

function angularConfig() {
    var app = angular.module("app", []);
    app.constant("baseUrl", contextPath);
    app.provider("listService", listProvider);
    
    app.config(["baseUrl", "listProvider", function(baseUrl, listProvider){
        listProvider.setBaseUrl(baseUrl);
    }]);

    app.controller("listUsuariosController", ['$scope, listService', function($scope, listService){
            
    }]);
    
    
}


function listProvider(){
    var _baseUrl;
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', function ($http) {
            return new listService($http, _baseUrl);
        }];
}


function listService($http, baseUrl){
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