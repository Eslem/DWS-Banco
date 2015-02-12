app.config(['$routeProvider', function($routeProvider) {

        $routeProvider.when("/cuenta", {
            templateUrl: "cuenta/list.html",
            controller: "CuentaListController"
        });

        $routeProvider.when("/cuenta/insert", {
            templateUrl: "cuenta/detail.html",
            controller: "CuentaInsertController"
        });

        $routeProvider.when("/cuenta/edit/:idCuenta", {
            templateUrl: "cuenta/detail.html",
            controller: "CuentaEditController"
        });

        $routeProvider.when('/cuenta/:id/movimiento/', {
            templateUrl: "cuenta/detail.html",
            controller: "CuentaInsertController"
        });

    }
]);