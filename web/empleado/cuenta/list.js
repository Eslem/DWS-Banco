app.controller("CuentaListController", function ($scope, $http) {

    $scope.findAll = function () {
        $http({
            method: "GET",
            url: contextPath + "/api/cuenta"
        }).success(function (data) {
            $scope.cuentas = data;
        }).error(function (data, status) {
            alert("Fatal error: " + status);
        });
    };

    $scope.findAll();

    $scope.deleteCuenta = function (id) {
        ok = confirm("¿ Está seguro que quiere borrar la cuenta de ID: " + id + " ?");

        if (ok) {
            $http({
                method: "DELETE",
                url: contextPath + "/api/cuenta" + id
            }).success(function () {
                $scope.findAll();
            }).error(function (data, status) {
                alert("Fatal error: " + status);
            });
        } else {
            $scope.findAll();
        } 
    };
    
    $scope.edit = function(id) {
        location.replace('#/cuenta/edit/' + id);
    };

    $scope.crearCuenta = function () {
        location.replace("#/cuenta/insert");
    };

    $scope.editCuenta = function (id) {
        location.replace("#/cuenta/edit/" + id);
    };

});
