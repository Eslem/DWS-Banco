
app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/administrador/', {
            templateUrl: "administrador/list.html",
            controller: "ListAdministradoresController"
        });

       /* $routeProvider.when('/usuario/insert', {
            templateUrl: "movimiento/detail.html",
            controller: "MovimientoInsertController"
        });*/

        $routeProvider.when('/administrador/update/:id', {
            templateUrl: "administrador/detail.html",
            controller: "UpdateAdministradoresController"
        });

    }
]);