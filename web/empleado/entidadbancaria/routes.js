app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/entidadbancaria/', {
            templateUrl: "entidadbancaria/list.html",
            controller: "EntidadBancariaListController"
        });

        $routeProvider.when('/entidadbancaria/insert/', {
            templateUrl: "entidadbancaria/detail.html",
            controller: "EntidadBancariaInsertController"
        });

        $routeProvider.when('/entidadbancaria/update/:id', {
            templateUrl: "entidadbancaria/detail.html",
            controller: "EntidadBancariaUpdateController"
        });

        $routeProvider.when('/entidadbancaria/delete/:id', {
            templateUrl: "entidadbancaria/detail.html",
            controller: "EntidadBancariaDeleteController"
        });
    }
]);