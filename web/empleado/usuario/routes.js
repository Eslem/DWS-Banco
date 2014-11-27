
app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/usuario/', {
            templateUrl: "usuario/list.html",
            controller: "ListUsuariosController"
        });

        $routeProvider.when('/usuario/insert', {
            templateUrl: "usuario/detail.html",
            controller: "UsuarioInsertController"
        });

        $routeProvider.when('/usuario/update/:id', {
            templateUrl: "usuario/detail.html",
            controller: "UpdateUserController"
        });

    }
]);