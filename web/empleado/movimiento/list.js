
app.controller("MovimientoListController", function ($scope, $http) {
    $scope.findAll = function (id) {
        $http({
            method: "GET",
            url: contextPath + "/api/movimiento/"
        }).success(function (data, status) {
            $scope.movimientos = data;
            data.fecha = new Date(data.fecha);
        }).error(function (data, status) {
            alert("Fatal error: " + status);
        });
    };


    

    $scope.deleteMovimiento = function (id) {
        ok = confirm("¿ Estas seguro que quieres borrar el movimiento con ID: " + id + " ?");
        if (ok) {
            $http({
                method: "DELETE",
                url: contextPath + "/api/movimiento/" + id
            }).success(function () {
                alert("Exito al borrar el movimiento con ID: " + id);
                $scope.findAll();
            }).error(function (data, status) {
                alert("Fatal error: " + status);
            });
        } else {
            $scope.findAll();
        }

    };
    $scope.findAll();





$scope.crear = function () {
        location.replace("#/movimiento/insert/");
    };

$scope.editar = function (id) {
        location.replace('#/movimiento/update/' + id);
    };

});
