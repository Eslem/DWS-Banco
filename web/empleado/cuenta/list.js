function CuentaListController($scope, $http) {
        
    $scope.findAll = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/cuenta/"
        }).success(function(data) {
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
    
    $scope.edit = function(id) {
        window.open(contextPath + "/empleado/cuenta/detail.html?id=" + id);
    };

}