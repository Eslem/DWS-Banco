
app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/sucursalbancaria/', {
            templateUrl: "sucursalbancaria/list.html",
            controller: "SucursalBancariaListController"
        });

        $routeProvider.when('/sucursalbancaria/insert', {
            templateUrl: "sucursalbancaria/detail.html",
            controller: "SucursalBancariaInsertController"
        });

        $routeProvider.when('/sucursalbancaria/update/:id', {
            templateUrl: "sucursalbancaria/detail.html",
            controller: "SucursalBancariaUpdateController"
        });

        $routeProvider.when('/sucursalbancaria/delete/:id', {
            templateUrl: "sucursalbancaria/detail.html",
            controller: "SucursalBancariaDeleteController"
        });
    }
]);