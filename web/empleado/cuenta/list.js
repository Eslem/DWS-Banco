app.controller("CuentaListController", function($scope, $http) {
        
    $scope.findAll = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/cuenta/"
        }).success(function(data) {
            alert("patata");
            $scope.cuentas = data;
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };
    
    $scope.findAll();

    $scope.deleteCuenta = function(id) {
        $http({
            method: "DELETE",
            url: contextPath + "/api/cuenta/" + id
        }).success(function() {
            $scope.findAll();
        }).error(function(data, status) {
            alert("Fatal error: " + status);
        });
    };
    
    $scope.launchApi = function(id) {
        window.open(contextPath + "/empleado/cuenta/detail.html?id=" + id);
    };

});