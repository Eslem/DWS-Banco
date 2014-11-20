app.config(['$routeProvider', function($routeProvider) {

        $routeProvider.when("/cuenta", {
            templateUrl: "cuenta/list.html",
            controller: "CuentaListController"
        });

        $routeProvider.when("/cuenta/new", {
            templateUrl: "cuenta/detail.html",
            controller: "CuentaNewController"
        });

        $routeProvider.when("/cuenta/edit/:idCuenta", {
            templateUrl: "cuenta/detail.html",
            controller: "CuentaEditController"
        });

        $routeProvider.when("/cuenta/delete/:idCuenta", {
            templateUrl: "cuenta/detail.html",
            controller: "CuentaDeleteController"
        });
    }
]);