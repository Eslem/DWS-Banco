app.controller("CuentaNewController", function($scope, $http, $routeParams) {
    $scope.cuenta = {
        
    };


    $scope.insert=function() {
        $http({
            url: contextPath + "/api/cuenta",
            method: "POST",
            data:$scope.cuenta
        }).success(function(data) {
            $scope.cuenta = data;
        }).error(function(data, status) {
            alert("");
        });
    };

});

app.controller("CuentaEditController", function($scope, $http, $routeParams) {
    $scope.cuenta = {
        idCuenta:$routeParams.idCuenta
    };

    $scope.get = function() {
        $http({
            url: contextPath + "/api/cuenta/" + $scope.cuenta.idCuenta,
            method: "GET"
        }).success(function(data) {
            $scope.cuenta = data;

        }).error(function(data, status) {
            alert("");
        });
    };

    $scope.get();

    $scope.update=function() {
        $http({
            url: contextPath + "/api/cuenta/" + $scope.cuenta.idCuenta,
            method: "PUT",
            data:$scope.cuenta
        }).success(function(data) {
            $scope.cuenta = data;
        }).error(function(data, status) {
            alert("");
        });
    };

});

app.controller("CuentaDeleteController", function($scope, $http, $routeParams) {
    $scope.cuenta = {
        
    };


    $scope.delete=function() {
        $http({
            url: contextPath + "/api/cuenta",
            method: "DELETE",
            data:$scope.cuenta
        }).success(function(data) {
            $scope.cuenta = data;
        }).error(function(data, status) {
            alert("");
        });
    };

});