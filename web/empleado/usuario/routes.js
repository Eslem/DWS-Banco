
app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/usuario/', {
            templateUrl: "usuario/list.html",
            controller: "listUsuariosController"
        });

       /* $routeProvider.when('/usuario/insert', {
            templateUrl: "movimiento/detail.html",
            controller: "MovimientoInsertController"
        });*/

        $routeProvider.when('/usuario/update/:id', {
            templateUrl: "usuario/detail.html",
            controller: "UpdateUserController"
        });

    }
]);