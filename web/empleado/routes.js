app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            templateUrl: "main.html"
        });
        
        $routeProvider.when('/panel', {
            templateUrl: "panel/panel.html"
        });
        
        $routeProvider.when('/login', {
            templateUrl: "login/login.html",
            controller:"LoginController"
        });
        
        $routeProvider.otherwise({
           redirectTo: '/' 
        });
    }
]);