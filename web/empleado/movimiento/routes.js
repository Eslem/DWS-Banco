
app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/movimiento/', {
            templateUrl: "movimiento/list.html",
            controller: "MovimientoListController"
        });

        $routeProvider.when('/movimiento/insert', {
            templateUrl: "movimiento/detail.html",
            controller: "MovimientoInsertController"
        });

        $routeProvider.when('/movimiento/update/:id', {
            templateUrl: "movimiento/detail.html",
            controller: "MovimientoUpdateController"
        });

        $routeProvider.when('/movimiento/delete/:id', {
            templateUrl: "movimiento/detail.html",
            controller: "MovimientoDeleteController"
        });
    }
]);