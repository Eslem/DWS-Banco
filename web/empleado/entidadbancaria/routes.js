app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/EntidadBancaria/', {
            templateUrl: "entidadbancaria/list.html",
            controller: "EntidadBancariaListController"
        });

        $routeProvider.when('/EntidadBancaria/insert', {
            templateUrl: "entidadbancaria/detail.html",
            controller: "EntidadBancariaInsertController"
        });

        $routeProvider.when('/EntidadBancaria/update/:id', {
            templateUrl: "entidadbancaria/detail.html",
            controller: "EntidadBancariaUpdateController"
        });

        $routeProvider.when('/EntidadBancaria/delete/:id', {
            templateUrl: "entidadbancaria/detail.html",
            controller: "EntidadBancariaDeleteController"
        });
    }
]);