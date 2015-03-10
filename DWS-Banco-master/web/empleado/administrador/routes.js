
app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/administrador/', {
            templateUrl: "administrador/list.html",
            controller: "ListAdministradoresController"
        });

        $routeProvider.when('/administrador/insert', {
            templateUrl: "administrador/detail.html",
            controller: "AdministradorInsertController"
        });

        $routeProvider.when('/administrador/update/:id', {
            templateUrl: "administrador/detail.html",
            controller: "UpdateAdministradoresController"
        });

    }
]);